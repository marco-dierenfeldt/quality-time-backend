# quality-time-backend
Backend for time tracking app (Demo do play with AWS)

# memory usage after Dockerfile package remastering

before: RUN apk add --no-cache bash ca-certificates nano zip curl openssh openssl openjdk8

$ docker ps --size
CONTAINER ID        IMAGE                         COMMAND                  CREATED             STATUS              PORTS                    NAMES               SIZE
a93b88c5c94f        quality-time-backend:latest   "java -jar qtb.jar /…"   21 seconds ago      Up 19 seconds       0.0.0.0:8080->8080/tcp   gifted_kepler       32.8kB (virtual 181MB)


$ docker system df
TYPE                TOTAL               ACTIVE              SIZE                RECLAIMABLE
Images              2                   1                   180.5MB             5.582MB (3%)
Containers          1                   1                   32.77kB             0B (0%)
Local Volumes       0                   0                   0B                  0B
Build Cache         0                   0                   0B                  0B


$ docker stats $(docker ps --format={{.Names}}) --no-stream
CONTAINER ID        NAME                CPU %               MEM USAGE / LIMIT     MEM %               NET I/O             BLOCK I/O           PIDS
a93b88c5c94f        gifted_kepler       0.09%               607.6MiB / 15.57GiB   3.81%               5.17kB / 0B         0B / 0B             38



after: RUN apk add --no-cache bash openjdk8

$ docker ps --size
CONTAINER ID        IMAGE                         COMMAND                  CREATED             STATUS              PORTS                    NAMES               SIZE
b5a6b29e9975        quality-time-backend:latest   "java -jar qtb.jar /…"   25 seconds ago      Up 23 seconds       0.0.0.0:8080->8080/tcp   angry_johnson       32.8kB (virtual 168MB)

$ docker system df
TYPE                TOTAL               ACTIVE              SIZE                RECLAIMABLE
Images              2                   1                   168MB               5.582MB (3%)
Containers          1                   1                   32.77kB             0B (0%)
Local Volumes       0                   0                   0B                  0B
Build Cache         0                   0                   0B                  0B

$ docker stats $(docker ps --format={{.Names}}) --no-stream
CONTAINER ID        NAME                CPU %               MEM USAGE / LIMIT     MEM %               NET I/O             BLOCK I/O           PIDS
b5a6b29e9975        angry_johnson       0.27%               568.5MiB / 15.57GiB   3.57%               5.36kB / 0B         0B / 0B             38

# Importent Hints: 

2019-05-12: Johann:

## Spring Security deactivated for first trail
In de.dierenfeldt.qualitytime.qualitytimebackend.QualityTimeBackendApplication
the Spring security feature was deactivated!!!

`@SpringBootApplication(`\
`exclude = {`\
`org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
`\
`}`\
`)`

## H2 Console in Browser
As defined in application.properties you should reach the h2 console in the browser via: http://localhost:8080/h2

Setting Name: Generic H2 (Embedded)
Driver Class: org.h2.Driver
JDBC URL:     jdbc:h2:mem:test;
User:         sa
Password:     

After the login you should see the "TIME_ENTRY" table

## Test Classes are missing
Work in Progress!!

## Postman Test-Calls

POST http://localhost:8080/timebooking/create

JSON (application/json) Body:
{
    "id": 3,
    "beginDate": "2019-04-11T08:30:00.000000",
    "endDate":  "2019-04-11T12:00:00.000000",
    "description": "Task am Vormittag"
}

GET http://localhost:8080/timebooking/1

should work
=======
Backend for time tracking app (Demo to play with AWS)