FROM openjdk:21-oracle

WORKDIR app
COPY . .

RUN sed -i 's/localhost/db/g' src/main/resources/application.properties

RUN ./gradlew build bootJar
ENTRYPOINT java -jar ./build/libs/klgback-1.0-SNAPSHOT.jar

EXPOSE 8080
