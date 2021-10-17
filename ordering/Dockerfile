FROM openjdk:11
EXPOSE 8080
ADD target/ordering-dockerfile.jar ordering-dockerfile.jar
ENTRYPOINT ["java","-jar","/ordering-dockerfile.jar"]
