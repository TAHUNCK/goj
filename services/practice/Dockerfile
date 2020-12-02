FROM openjdk:11-jre
MAINTAINER <CK>
RUN echo "Asia/Shanghai" > /etc/timezone
ADD target/*.jar practice.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","/practice.jar"]