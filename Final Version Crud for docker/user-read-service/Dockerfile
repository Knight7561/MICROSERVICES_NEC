FROM openjdk:11.0-jre
EXPOSE 8083
ADD /target/user-read-service-0.0.1-SNAPSHOT.jar user-read-service-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","user-read-service-0.0.1-SNAPSHOT.jar","--spring.datasource.url=jdbc:mysql://db:3306/db_example"]