FROM openjdk:11-oracle
ADD target/paymentService-0.0.1-SNAPSHOT.jar paymentService-0.0.1-SNAPSHOT.jar 
EXPOSE 8082
ENTRYPOINT ["java","-jar","/paymentService-0.0.1-SNAPSHOT.jar"]