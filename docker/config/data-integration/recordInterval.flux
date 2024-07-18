//params = {bucket: "twinficient", measurement: "celestra", field: "HgRT"}
//params = {bucket: "twinficient-aggregates", measurement: "aggregations", field: "ErrorCodesPerDay"}
params = {bucket: "twinficient-score", measurement: "aggregations", field: "RtInInterval"}
// overridden by the task manager 
bucket = params.bucket
measurement = params.measurement
field = params.field

queryTime = (fn, c) => 
	from(bucket: bucket) 
	|> range(start: 0)  
	|> filter(fn: (r) => r._measurement == measurement and r._field == field)
	|> group(columns: []) 
	|> fn() 
	|> map(fn: (r) =>({r with _value: r._time, _field: c}))

sFirst = queryTime(fn: first, c: "first") 
sLast = queryTime(fn: last, c: "last")
union(tables: [sFirst, sLast]) |> drop(columns: ["Company", "CelNr", "HgNr", "HzNr", "_stop"]) |> pivot(rowKey: ["_start"], columnKey: ["_field"], valueColumn: "_value") |> drop(columns: ["_start"]) 