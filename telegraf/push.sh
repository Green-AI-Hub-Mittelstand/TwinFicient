#!/bin/bash

source ../docker/.env

export INFLUX_TOKEN=$INFLUXDB_INIT_ADMIN_TOKEN
export INFLUX_ORG=$INFLUXDB_INIT_ORG
export INFLUX_BUCKET=$INFLUXDB_INIT_BUCKET
export COMPANIES_FILE=./tmp/companies
export INFLUX_DB_ADDRESS=http://127.0.0.1:8086

echo "resolving company names..."

rm $COMPANIES_FILE
telegraf --config celestra-companies.conf --quiet --once

mapfile -t COMPANIES < $COMPANIES_FILE

LOOP_START=`date +%s`

for INDEX in "${!COMPANIES[@]}"; do
   export COMPANY="${COMPANIES[$INDEX]}"
   echo "Pushing content for '$COMPANY' $(($INDEX+1))/${#COMPANIES[@]}"
   RUN_START=`date +%s`
   telegraf --config celestra-migration.conf --once --quiet
   RUN_END=`date +%s`
   RUN_SECONDS=$(( $RUN_END - $RUN_START ))
   echo Data pushed in $(( RUN_SECONDS / 60)) min $(( RUN_SECONDS % 60)) sec.
done

LOOP_END=`date +%s`
LOOP_SECONDS=$(( $LOOP_END - $LOOP_START ))
echo Total time was $(( LOOP_SECONDS / 60)) min $(( LOOP_SECONDS % 60)) sec.