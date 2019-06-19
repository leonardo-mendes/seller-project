#!/bin/sh

echo "********************************************************"
echo "Waiting for the configuration server to start on port 8080"
echo "********************************************************"
while ! `nc -z 172.32.0.103 8080 `; do sleep 3; done
echo ">>>>>>>>>>>> Configuration Server has started"

java -Dserver.port=$SERVER_PORT \
    -Dfile.encoding=UTF-8       \
    -jar /usr/local/store/@project.build.finalName@.jar