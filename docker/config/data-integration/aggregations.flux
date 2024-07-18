import "internal/debug"
import "date"
import "array"

// used for testing
params = {startOfDay: time(v: "2022-01-12T22:00:00Z"), endOfDay: time(v: "2022-01-13T22:00:00Z"), srcBucket: "twinficient"}

// overridden by the task manager 
startOfDay = params.startOfDay
endOfDay = params.endOfDay
srcBucket = params.srcBucket

filterRelevantFields = (t=<-) => t |> filter(fn: (r) => r._field == "HgRT" or r._field == "HgLastErr" or r._field == "HzIst" or r._field == "OutTemp")
filterFilledFields = (t=<-) => t |> filter(fn: (r) => exists r.HgRT and exists r.HgLastErr and exists r.HzIst and exists r.OutTemp)

runtimes = (t=<-) => 
    t 
    |> filter(fn: (r) => r._measurement == "celestra")
    |> filterRelevantFields()
    |> pivot(rowKey: ["_time"], columnKey: ["_field"], valueColumn: "_value")
    |> filterFilledFields()
	|> map(fn: (r) => ({r with Runtime: if r.HgLastErr != 9 and r.HgRT > 0 then float(v: r.HgRT) / 3600.0 else debug.null(type: "float")})) 
	

previousDayRuntimes = from (bucket: srcBucket)
	// choose the previous day and try to get a least 1 entry 
    |> range(start: date.sub(from: startOfDay, d: 12h), stop: startOfDay)
	|> runtimes()
	// take the last entry that we have for runtime
    |> last(column: "HgRT")

currentDayRuntimes = from (bucket: srcBucket)
    |> range(start: startOfDay, stop: endOfDay)
	|> runtimes()

// perform an aggregation on the hole datastream with all values at once
aggregateValues = (column="_value", t=<-) => {

    isValidTemp = (v) => exists v and v > -300.0 and v < 300

    fn = (r, accumulator) => 
        ({
            
            HzIstTotal: if accumulator.TodaysRecord and isValidTemp(v: r.HzIst) then accumulator.HzIstTotal + 1 else accumulator.HzIstTotal,
            HzIstSum: if accumulator.TodaysRecord and isValidTemp(v: r.HzIst) then accumulator.HzIstSum + r.HzIst else accumulator.HzIstSum, 

            OutTempTotal: if accumulator.TodaysRecord and isValidTemp(v: r.OutTemp)  then accumulator.OutTempTotal + 1 else accumulator.OutTempTotal,
            OutTempSum: if accumulator.TodaysRecord and isValidTemp(v: r.OutTemp) then accumulator.OutTempSum + r.OutTemp else accumulator.OutTempSum,
            
            // for the sum we only consider the current day, but we check if it differs from the previous day's errorCode
            ErrorCodesPerDay: if accumulator.TodaysRecord and r.HgLastErr != accumulator.LastErr then accumulator.ErrorCodesPerDay + 1 else accumulator.ErrorCodesPerDay,
            LastErr: r.HgLastErr,

            TodaysRecord: true,

			// due to rearrangements of heaters it could happen that we have a high difference in runtime between two measurements
			// just a small workaround here to not consider only "valid" runtimes
            RtPerDay: if exists r.Runtime and r.Runtime <= 24.0 and r.Runtime > 0 then accumulator.RtPerDay + r.Runtime else accumulator.RtPerDay,
            

        })
    identity = {

            HzIstTotal: 0,
            HzIstSum: 0.0, 

            OutTempTotal: 0,
            OutTempSum: 0.0,

            LastErr: 0,
            ErrorCodesPerDay: 0,

            TodaysRecord: false, // the first record is from the previous day

            RtPerDay: 0.0
            
    }
	// use a reduce method to get just one entry per heater (table)
    return t |> reduce(fn: fn, identity: identity) 
    	// compute mean values 
        |> map(fn: (r) => ({r with HzOutMean: if r.OutTempTotal == 0 then debug.null(type: "float") else r.OutTempSum / float(v: r.OutTempTotal),
            HzIstMean: if r.HzIstTotal == 0 then debug.null(type: "float") else r.HzIstSum / float(v: r.HzIstTotal),
            OutTempMean: if r.OutTempTotal == 0 then debug.null(type: "float") else r.OutTempSum / float(v: r.OutTempTotal),
            // assign a time value
            _time: date.add(to: startOfDay, d: 12h),
            
         }))
        // compute degree days that will be used for the score in the dashboards
        |> map(fn: (r) => ({r with DegreeDay: if r.OutTempMean <= 15 then r.HzIstMean - r.OutTempMean else 0.0 }))
        |> drop(columns: ["HzIstTotal", "HzIstSum", "OutTempTotal", "OutTempSum" , "TodaysRecord", "LastErr"])
}

union(tables: [previousDayRuntimes, currentDayRuntimes]) |>  drop(columns: ["_start", "_stop"]) 
    // prepare runtime => just save the differences
    |> difference(nonNegative: true, columns: ["Runtime"])
    |> aggregateValues()
    |> yield()