FROM openjdk:21-oracle

WORKDIR app
COPY . .

RUN sed -i 's/localhost/db/g' application.properties

RUN ./gradlew bootJar

ENTRYPOINT java -jar ./build/libs/klgback-1.0-SNAPSHOT.jar

EXPOSE 8080
