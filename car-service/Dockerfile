FROM openjdk:21

WORKDIR /app

COPY target/car-service.jar /app/car-service.jar

EXPOSE 8082

CMD ["java", "-jar", "car-service.jar"]