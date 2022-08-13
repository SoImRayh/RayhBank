FROM maven as maven
RUN mkdir "app"
WORKDIR /app
COPY . .
RUN mvn package

#
#FROM openjdk:11-jre
#COPY --from=maven /target/RayhBank-0.0.1-SNAPSHOT.jar /app/
#WORKDIR /app
#ENTRYPOINT = ["java", "-jar", "RayhBank-0.0.1-SNAPSHOT.jar"]


