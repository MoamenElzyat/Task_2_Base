FROM openjdk:23-jdk-slim

LABEL maintainer="Asmem"

WORKDIR /app

COPY target/Task_2-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 13244

ENTRYPOINT ["java", "-jar", "/app/app.jar"]