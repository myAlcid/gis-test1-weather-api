FROM openjdk:11
WORKDIR /usr/local/server
COPY /target/weather_api-0.0.1-SNAPSHOT.jar ./
EXPOSE 8080
ENTRYPOINT exec java -jar weather_api-0.0.1-SNAPSHOT.jar