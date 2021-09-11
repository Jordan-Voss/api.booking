#!/bin/bash
mvn package
docker buildx build --platform linux/arm/v7 -t api.booking .
docker save --output booking.tar api.booking:latest
scp booking.tar pi@192.168.0.185:/home/pi
ssh pi@192.168.0.185 'sudo ./package.sh'


