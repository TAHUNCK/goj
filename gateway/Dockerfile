FROM openjdk:11-jre
MAINTAINER <CK>
RUN echo "Asia/Shanghai" > /etc/timezone
ADD target/*.jar gateway.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/gateway.jar"]