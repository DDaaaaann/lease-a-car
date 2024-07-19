FROM openjdk:21

WORKDIR /app

COPY target/lease-service.jar /app/lease-service.jar

EXPOSE 8083

CMD ["java", "-jar", "lease-service.jar"]