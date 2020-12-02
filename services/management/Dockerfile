FROM openjdk:11-jre
MAINTAINER <CK>
RUN echo "Asia/Shanghai" > /etc/timezone
ADD target/*.jar management.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/management.jar"]