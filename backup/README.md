# Influx scripts

This folder contains backup data and scripts to import and export influxdb data.

## Restore Backup

To load data into your bucket, run *delete-bucket.sh* first, to remove the predefined bucket.
If you deployed already the [templates](../templates/README.md), then run 'cleanup-aggregates.sh' to delete and recreate the aggregation bucket with runtime per day aggregations.

Run *restore-bucket.sh* to load the metrics into the *twinficient* bucket.

## Perform Backup

To create a backup of your data, run *backup-bucket.sh*. Data is written then into the [backup folder](./backup/bucket/twinficient).

