# latest oracle openjdk is the basis
#FROM openjdk:oracle
## copy jar file into container image under app directory
#COPY target/booking-api-1.0-SNAPSHOT.jar app/api.jar
## expose server port accept connections
#EXPOSE 8080
## start application
#CMD ["java", "-jar", "app/apiap.jar"]


FROM arm32v7/adoptopenjdk:11-jdk-hotspot
RUN addgroup spring
RUN adduser spring --ingroup spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api.jar
ENTRYPOINT ["java", "-jar", "/api.jar"]


#    from jenkins/jenkins:lts
#    USER root
#    RUN apt-get update -qq \
#        && apt-get install -qqy apt-transport-https ca-certificates curl gnupg2 software-properties-common
#    RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
#    RUN add-apt-repository \
#       "deb [arch=amd64] https://download.docker.com/linux/debian \
#       $(lsb_release -cs) \
#       stable"
#    RUN apt-get update  -qq \
#        && apt-get install docker-ce=17.12.1~ce-0~debian -y
#    RUN usermod -aG docker jenkins



#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
#
#
#COPY pom.xml /build/
#COPY src /build/src/
#
#WORKDIR /build/
#RUN mvn package
#
#FROM openjdk:8-jre-alpine
#
#
#COPY --from=MAVEN_BUILD /build/target/booking-api-1.0-SNAPSHOT.jar /app/
#
#ENTRYPOINT ["java", "-jar", "booking-api-1.0-SNAPSHOT.jar"]



#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/api-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java","-jar","app.jar"]
#
#EXPOSE 8080


#FROM arm32v7/adoptopenjdk:11-jdk-hotspot
#RUN addgroup spring
#RUN adduser spring --ingroup spring
#USER spring:spring
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} api.jar
#ENTRYPOINT ["java", "-jar", "/api.jar"]