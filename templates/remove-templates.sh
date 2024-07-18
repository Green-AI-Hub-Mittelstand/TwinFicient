#!/bin/bash
TWINFICIENT_STACK_ID=$(influx stacks | grep twinficient | awk '{print $1}')


if [ "$TWINFICIENT_STACK_ID" != "" ] 
then
    echo "Deleting stack $TWINFICIENT_STACK_ID and all assigned resources."
    influx stacks rm --stack-id $TWINFICIENT_STACK_ID
else 
    echo "Stack twinficient not found"
fi 
