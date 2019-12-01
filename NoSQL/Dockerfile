FROM openjdk:11
ADD target/books-api.jar books-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/books-api.jar"]