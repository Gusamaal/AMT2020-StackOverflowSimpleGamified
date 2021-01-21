#!/bin/sh
cp ../target/stackoverflow-simplified.war images/openliberty/apps
cp ../src/main/liberty/config/server.xml images/openliberty/configs
cp ../src/main/liberty/config/postgresql*.jar images/openliberty/configs
docker-compose -f ./topologies/stackoverflow/docker-compose.yml build --no-cache
