#!/bin/bash

. ./setenv

echo""
echo "======== start to build protobuf ==============="
cd protobuf
./build.sh

echo""
echo "======== start to exec the mvn test ============"
cd ../mvn_prj
./test.sh

cd ../

echo""
echo "======== completed ============================="
