#!/bin/bash
TWINFICIENT_STACK_ID=$(influx stacks | grep twinficient | awk '{print $1}')


if [ "$TWINFICIENT_STACK_ID" == "" ] 
then
    echo "Init Stack"
    influx stacks init \
        -o twinficient \
        -n "twinficient" \
        -d "Twinficient Stack for monitoring" >/dev/null
    TWINFICIENT_STACK_ID=$(influx stacks | grep twinficient | awk '{print $1}')
fi 
echo $TWINFICIENT_STACK_ID

influx apply -f twinficient-template.yaml  --stack-id $TWINFICIENT_STACK_ID
