FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080


#FROM arm32v7/adoptopenjdk:11-jdk-hotspot
#RUN addgroup spring
#RUN adduser spring --ingroup spring
#USER spring:spring
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} api.jar
#ENTRYPOINT ["java", "-jar", "/api.jar"]