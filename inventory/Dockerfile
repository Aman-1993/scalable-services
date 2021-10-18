FROM openjdk:11
EXPOSE 8081
ADD target/inventory-dockerfile.jar inventory-dockerfile.jar
ENTRYPOINT ["java","-jar","/inventory-dockerfile.jar"]
