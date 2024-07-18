#!/bin/bash

DELETION_START=`date +%s`
current_time_as_stop_time=$(date --rfc-3339=ns)

influx bucket delete --name twinficient-aggregates
influx bucket create --name twinficient-aggregates

DELETION_END=`date +%s`
DELETION_SECONDS=$(( $DELETION_END - $DELETION_START ))
echo Total time was $(( DELETION_SECONDS / 60)) min $(( DELETION_SECONDS % 60)) sec.