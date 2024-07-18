#!/bin/bash

STACK_ADMIN=docker-compose-00-admin.yml
STACK_STORAGE=docker-compose-10-storage.yml
STACK_AAS=docker-compose-20-aas.yml
STACK_AAS_V3=docker-compose-21-aas-v3.yml
STACK_OBSERV=docker-compose-30-observability.yml

PORTAINER_PWD=$(cat ./config/portainer/admin-password)

set -a
source .env
set +a


docker compose -p twinficient \
    -f $STACK_ADMIN -f $STACK_AAS -f $STACK_AAS_V3 -f $STACK_STORAGE  -f $STACK_OBSERV \
    up -d

echo ""
echo "=== twinficient services  ==="
echo ""

echo "Portainer:        http://portainer.$EXTERNAL_HOSTNAME (admin / $PORTAINER_PWD)"
echo "InfluxDB:         http://influxdb.$EXTERNAL_HOSTNAME ($INFLUXDB_INIT_USERNAME / $INFLUXDB_INIT_PASSWORD)"
echo "AasRegistry v2:   http://aasregistry.$EXTERNAL_HOSTNAME"
echo "PPR Dashboard v2: http://pprdashboard.$EXTERNAL_HOSTNAME" 
echo "AasRegistry v3:   http://aas-registry-v3.$EXTERNAL_HOSTNAME" 
echo "SmRegistry v3:    http://sm-registry-v3.$EXTERNAL_HOSTNAME" 
echo "Shells v3:        http://aas-environment.$EXTERNAL_HOSTNAME/shells?limit=100000" 
echo "Submodels v3:     http://aas-environment.$EXTERNAL_HOSTNAME/submodels?limit=100000" 
echo "Concept Descr v3: http://aas-environment.$EXTERNAL_HOSTNAME/concept-descriptions?limit=100000" 
echo "AasGui:           http://aasgui.$EXTERNAL_HOSTNAME/"
echo "Prometheus:       http://prometheus.$EXTERNAL_HOSTNAME"
echo "Grafana:          http://grafana.$EXTERNAL_HOSTNAME (admin / admin)"

