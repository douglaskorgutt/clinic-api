FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8085
ARG JAR_FILE="build/libs/clinic-api-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]