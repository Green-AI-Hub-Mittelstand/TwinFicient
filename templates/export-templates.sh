#!/bin/bash

BACKUP_START=`date +%s`

influx export all --org twinficient --filter=labelName=twinficient -f twinficient-template.yaml


BACKUP_END=`date +%s`
BACKUP_SECONDS=$(( $BACKUP_END - $BACKUP_START ))
echo Total time was $(( BACKUP_SECONDS / 60)) min $(( BACKUP_SECONDS % 60)) sec.