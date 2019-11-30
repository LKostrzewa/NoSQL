FROM openjdk:11
ADD target/docker-java.jar docker-java.jar
ENTRYPOINT ["java","-jar","docker-java.jar"]