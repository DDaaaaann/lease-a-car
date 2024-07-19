FROM openjdk:21

WORKDIR /app

COPY target/gateway-service.jar /app/gateway-service.jar

EXPOSE 8080

CMD ["java", "-jar", "gateway-service.jar"]