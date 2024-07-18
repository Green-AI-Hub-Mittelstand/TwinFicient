#!/bin/bash

STACK_ADMIN=docker-compose-00-admin.yml
STACK_STORAGE=docker-compose-10-storage.yml
STACK_AAS=docker-compose-20-aas.yml
STACK_OBSERV=docker-compose-30-observability.yml

source .env

PORTAINER_PWD=$(cat ./config/portainer/admin-password)
echo "restart"
docker compose  \
    -f $STACK_ADMIN -f $STACK_STORAGE -f $STACK_AAS -f $STACK_OBSERV \
    restart influxdb 

echo "InfluxDB:      http://influxdb.$EXTERNAL_HOSTNAME ($INFLUXDB_INIT_USERNAME / $INFLUXDB_INIT_PASSWORD)"