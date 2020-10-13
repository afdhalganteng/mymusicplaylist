FROM openjdk:11
ADD target/my-spotyfy-0.0.1-SNAPSHOT.jar my-spotyfy-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","my-spotyfy-0.0.1-SNAPSHOT.jar"]