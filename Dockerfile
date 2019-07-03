#
# Alpine stuff
#
FROM alpine:latest
RUN apk update
RUN apk add --no-cache bash ca-certificates nano zip curl openssh openssl openjdk8

#
# copy the deployable to the target directory
#
ADD ./target/quality-time-backend-0.0.1-SNAPSHOT.jar /opt/qtb.jar

#
# enter the working directory
#
WORKDIR /opt

#
# expose ports for incomint calls
#
EXPOSE 8080

#
# Starting the Spring Boot Application
#
ENTRYPOINT ["java", "-jar", "qtb.jar"]

CMD [""]
