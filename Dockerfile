FROM java:8-alpine

LABEL maintainer="face-money"

ADD camera-holder-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]