#!/bin/bash
rm -rf protobuf/class/*
cd mvn_prj
./clean.sh
cd ..
rm -f mvn_prj/src/main/java/com/example/tutorial/AddressBookProtos.java

rm -f datafiles/bb.txt
touch datafiles/bb.txt
