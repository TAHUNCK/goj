FROM openjdk:11-jre
MAINTAINER <CK>
RUN echo "Asia/Shanghai" > /etc/timezone
ADD target/*.jar user.jar
EXPOSE 8003
ENTRYPOINT ["java","-jar","/user.jar"]