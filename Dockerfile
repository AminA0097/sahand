FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/sahand-1404.03.27.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
