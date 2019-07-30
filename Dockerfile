FROM openjdk:8
ADD ./target/spring-crud-cassandra-demo.jar spring-crud-cassandra-demo.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","--spring.config.location=file:${configDirectory}/application.properties","spring-crud-cassandra-demo.jar"]



  
