// used for testing
params = {start: time(v: "2024-05-29T10:00:00Z"), stop: time(v: "2024-05-29T10:10:00Z"), srcBucket: "dfki_dashboard"}

// overridden by the task manager 
start = params.start
stop = params.stop
srcBucket = params.srcBucket
		
from (bucket: srcBucket)
    |> range(start: start, stop: stop)
    |> filter(fn: (r) =>  r._measurement == "heater")
    |> pivot(rowKey: ["Company", "CelNr", "HzNr", "HgNr", "_time"], columnKey: ["_field"], valueColumn: "_value" )
    |> drop(columns: ["_stop", "_start", "_measurement"])
