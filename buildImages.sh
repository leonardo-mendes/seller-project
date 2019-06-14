#!/bin/sh
cd order-service
mvn package docker:build
cd../phone-service
mvn package docker:build
cd../service-discovery
mvn package docker:build
cd../config-server
mvn package docker:build
