#!/bin/bash

RESTORE_START=`date +%s`
echo Create twinficient bucket
influx restore --bucket=twinficient ./bucket/twinficient
echo Try creating aggregate bucket
influx bucket create --name twinficient-aggregates
RESTORE_END=`date +%s`
RESTORE_SECONDS=$(( $RESTORE_END - $RESTORE_START ))
echo Total time was $(( RESTORE_SECONDS / 60)) min $(( RESTORE_SECONDS % 60)) sec.