#!/bin/bash

DELETION_START=`date +%s`
influx bucket delete --name=twinficient-aggregates
DELETION_END=`date +%s`
DELETION_SECONDS=$(( $DELETION_END - $DELETION_START ))
echo Total time was $(( DELETION_SECONDS / 60)) min $(( DELETION_SECONDS % 60)) sec.