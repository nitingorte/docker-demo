FROM openjdk:17

WORKDIR /app

COPY target/UserCRUDDockerDemo-0.0.1-SNAPSHOT.jar /app/

# RUN mvn package

EXPOSE 8080

CMD ["java", "-jar", "UserCRUDDockerDemo-0.0.1-SNAPSHOT.jar"]