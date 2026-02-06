FROM eclipse-temurin:21-jre
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/springbootrest  app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]