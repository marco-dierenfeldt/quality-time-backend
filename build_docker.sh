#!/usr/bin/env bash

./mvnw clean install

docker build -t quality-time-backend .

docker run -it -p 8080:8080 quality-time-backend:latest /bin/bash


