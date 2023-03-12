FROM eclipse-temurin:17.0.5_8-jre-alpine
RUN mkdir /app
WORKDIR /app
COPY predict-service-1.0.0.jar predict.jar
CMD ["java", "-jar", "predict.jar"]