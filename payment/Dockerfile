FROM openjdk:11
EXPOSE 8082
ADD target/payment-dockerfile.jar payment-dockerfile.jar
ENTRYPOINT ["java","-jar","/payment-dockerfile.jar"]
