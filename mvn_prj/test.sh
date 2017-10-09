#!/bin/bash


datafile="${PWD}/../datafiles/bb.txt"
rm -f ${datafile}
touch ${datafile}

mvn clean test

#mvn -e -Dtest=my.protobuf01.AddPerson test
#mvn -e -Dtest=my.protobuf01.ListPerson test
#
hexdump -C ${datafile}
