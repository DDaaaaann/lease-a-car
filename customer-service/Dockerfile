FROM openjdk:21

WORKDIR /app

COPY target/customer-service.jar /app/customer-service.jar

EXPOSE 8081

CMD ["java", "-jar", "customer-service.jar"]