FROM openjdk:21-oracle

WORKDIR hsqldb
COPY hsqldb .

RUN mkdir -p data

ENTRYPOINT cd data && java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file.testdb --dbname.0 testdb
