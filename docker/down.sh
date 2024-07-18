#!/bin/bash

STACK_ADMIN=docker-compose-00-admin.yml
STACK_STORAGE=docker-compose-10-storage.yml
STACK_AAS=docker-compose-20-aas.yml
STACK_AAS_V3=docker-compose-21-aas-v3.yml
STACK_OBSERV=docker-compose-30-observability.yml


docker compose -p twinficient \
    -f $STACK_ADMIN -f $STACK_STORAGE -f $STACK_AAS -f $STACK_AAS_V3 -f $STACK_OBSERV \
    down