#!/bin/bash

SRC_DIR=$PWD
DST_DIR=$PWD/class

protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto


cp -rf ${DST_DIR}/*  ${PWD}/../mvn_prj/src/main/java/
