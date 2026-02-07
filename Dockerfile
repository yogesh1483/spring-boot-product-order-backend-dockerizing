FROM eclipse-temurin:21-jre
WORKDIR /opt
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Xms64m","-Xmx128m","-jar","app.jar"]
