FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY target/sahand-1404.03.27.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
