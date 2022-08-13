FROM openjdk:11
EXPOSE 8080
ADD target/rayhbank.jar rayhbank.jar
ENTRYPOINT ["java", "-jar", "rayhbank.jar"]

#
#FROM openjdk:11-jre
#COPY --from=maven /target/RayhBank-0.0.1-SNAPSHOT.jar /app/
#WORKDIR /app
#ENTRYPOINT = ["java", "-jar", "RayhBank-0.0.1-SNAPSHOT.jar"]


