FROM amazoncorretto:19
MAINTAINER AbrilAlarcon
COPY target/tpfinal-0.0.1-SNAPSHOT.jar tpfinal-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/tpfinal-0.0.1-SNAPSHOT.jar"]