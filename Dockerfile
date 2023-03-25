FROM amazoncorretto:19-alpine-jdk
MAINTAINER Abril Alarcon
COPY target/tpfinal-0.0.1-SNAPSHOT.jar backend-app.jar
ENTRYPOINT ["java", "-jar", "/backend-app.jar"]