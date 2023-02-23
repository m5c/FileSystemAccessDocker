FROM maven:3.6-jdk-13 AS build
MAINTAINER maximilian schiedermeier
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY google_checks.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package
WORKDIR /usr/src/app/target
CMD java -jar FileSystemAccessDocker.jar

