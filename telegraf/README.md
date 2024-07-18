# Overview

We describe the SQLite data migration to influxDB in this file. This setup could just be seen as example, as it is quite use case specific.

## SQLite content migration

Install [Telegraf](https://www.influxdata.com/time-series-platform/telegraf/) to migrate records from the SQLite file *ModbusDatabase.db* to the local InfluxDB installation. The ModbusDatabase.db file needs to be placed in this folder. Reading the entire SQL file at once could be problematic for Telegraf. Therefore, we send data for each company individually by limiting the retrieved data via the SQL WHERE clause.

Set up the [docker stack](../docker/README.md) stack and invoke the *push.sh* script to deploy all data to InfluxDB.

The migrated content is already part of the InfluxDB docker stack volume and has been pushed to the repository.

### Program output
``` 
resolving company names...
Pushing content for 'a' 1/36
Data pushed in 6 min 15 sec.
Pushing content for 'b' 2/36
Data pushed in 2 min 13 sec.
Pushing content for 'c' 3/36
Data pushed in 10 min 29 sec.
Pushing content for 'd' 4/36
Data pushed in 14 min 31 sec.
Pushing content for 'e' 5/36
Data pushed in 3 min 0 sec.
Pushing content for 'f' 6/36
Data pushed in 1 min 55 sec.
Pushing content for 'g' 7/36
Data pushed in 6 min 24 sec.
Pushing content for 'h' 8/36
Data pushed in 2 min 29 sec.
Pushing content for 'i' 9/36
Data pushed in 0 min 46 sec.
Pushing content for 'j' 10/36
Data pushed in 1 min 10 sec.
Pushing content for 'k' 11/36
Data pushed in 1 min 14 sec.
Pushing content for 'l' 12/36
Data pushed in 1 min 55 sec.
Pushing content for 'm' 13/36
Data pushed in 11 min 27 sec.
Pushing content for 'n' 14/36
Data pushed in 3 min 15 sec.
Pushing content for 'o' 15/36
Data pushed in 0 min 26 sec.
Pushing content for 'p' 16/36
Data pushed in 0 min 15 sec.
Pushing content for 'q' 17/36
Data pushed in 0 min 14 sec.
Pushing content for 'r' 18/36
Data pushed in 0 min 18 sec.
Pushing content for 's' 19/36
Data pushed in 0 min 23 sec.
Pushing content for 't' 20/36
Data pushed in 0 min 22 sec.
Pushing content for 'u' 21/36
Data pushed in 2 min 4 sec.
Pushing content for 'v' 22/36
Data pushed in 1 min 3 sec.
Pushing content for 'w' 23/36
Data pushed in 1 min 7 sec.
Pushing content for 'x' 24/36
Data pushed in 0 min 50 sec.
Pushing content for 'y' 25/36
Data pushed in 0 min 32 sec.
Pushing content for 'z' 26/36
Data pushed in 4 min 24 sec.
Pushing content for '1' 27/36
Data pushed in 0 min 21 sec.
Pushing content for '2' 28/36
Data pushed in 0 min 16 sec.
Pushing content for '3' 29/36
Data pushed in 2 min 23 sec.
Pushing content for '4' 30/36
Data pushed in 0 min 22 sec.
Pushing content for '5' 31/36
Data pushed in 0 min 48 sec.
Pushing content for '6' 32/36
Data pushed in 1 min 30 sec.
Pushing content for '7' 33/36
Data pushed in 0 min 17 sec.
Pushing content for '8' 34/36
Data pushed in 1 min 25 sec.
Pushing content for '9' 35/36
Data pushed in 0 min 50 sec.
Pushing content for '10' 36/36
Data pushed in 0 min 19 sec.
Total time was 87 min 35 sec.
```

### Check Migration

Run the *check-migration.sh* script to verify that the migration was successful. This ensures that no data is missing in the InfluxDB bucket.

We have duplicate entries (same timestamp for a device) in the SQL database as Celestra metrics are pulled multiple times due to possible failures.

In InfluxDB, metrics are considered the same instance if they have the same timestamp, tags, and measurement value. Currently, we create an additional tag value for each metric with a different value for each duplicate so that no value will be overridden.
