FROM openjdk:11.0-jre
EXPOSE 8761
ADD /target/crud-discovery-service-0.0.1-SNAPSHOT.jar crud-discovery-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","crud-discovery-service-0.0.1-SNAPSHOT.jar","--spring.datasource.url=jdbc:mysql://db:3306/db_example"]