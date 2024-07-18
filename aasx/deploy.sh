#!/bin/bash

for f in */; do 
    withoutSlash=${f%/}
    echo $withoutSlash
   # fileOut=../docker/data/aasx/v3/$withoutSlash.aasx
    fileOut=../$withoutSlash.aasx
    echo "Deploying $fileOut ..."
    cd $withoutSlash
    jar -cfM $fileOut .
    cd ..
done
