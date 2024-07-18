#!/bin/bash

source ../docker/.env

export INFLUX_TOKEN=$INFLUXDB_INIT_ADMIN_TOKEN
export INFLUX_ORG=$INFLUXDB_INIT_ORG
export INFLUX_BUCKET=$INFLUXDB_INIT_BUCKET
export INFLUX_DB_ADDRESS=http://127.0.0.1:8086

LOOP_START=`date +%s`

rm -rf ./tmp/influx-check
rm -rf ./tmp/sqlite-check

echo "Resolving SQLite data info ..."
telegraf --config celestra-migration-check-sqlite.conf --once --quiet
echo "Resolving Influx data info ..."
telegraf --config celestra-migration-check-influx.conf --once --quiet

if cmp -s "./tmp/influx-check" "./tmp/sqlite-check"
then
   echo "The content was transmitted correctly!!!!"
else
   echo "The content is not the same: check './tmp/influx-check' './tmp/sqlite-check'"
   set -e
fi

LOOP_END=`date +%s`
LOOP_SECONDS=$(( $LOOP_END - $LOOP_START ))
echo Total time was $(( LOOP_SECONDS / 60)) min $(( LOOP_SECONDS % 60)) sec.