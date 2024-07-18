#!/bin/bash

set -o allexport
source ./docker/.env set
set +o allexport

influx config rm twinficient-local >/dev/null
influx config create --config-name twinficient-local \
  --host-url http://127.0.0.1:8086 \
  --org $INFLUXDB_INIT_ORG \
  --token $INFLUXDB_INIT_ADMIN_TOKEN \
  --active
