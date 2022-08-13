FROM openjdk:11
EXPOSE 8080
ADD target/rayhbank.jar rayhbank.jar
ENTRYPOINT ["java", "-jar", "rayhbank.jar"]
