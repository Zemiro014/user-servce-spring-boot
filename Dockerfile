FROM maven:3.8.8-eclipse-temurin-17 AS BUILD
WORKDIR /app
COPY target/*.jar userServiceApi.jar
EXPOSE 8080
CMD ["java", "-jar", "userServiceApi.jar"]