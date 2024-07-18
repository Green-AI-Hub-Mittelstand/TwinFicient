#!/bin/bash

for f in ../docker/data/aasx/*.aasx; do 
    filename=$(basename $f);
    withoutSuffix=${filename%.aasx};
    echo "Unzipping $withoutSuffix ..."; 
    mkdir -p $withoutSuffix
    cd $withoutSuffix
    rm -rf *
    jar -xvf ../$f 
    cd ..
done
