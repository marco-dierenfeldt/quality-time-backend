# quality-time-backend
Backend for time tracking app (Demo do play with AWS)

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