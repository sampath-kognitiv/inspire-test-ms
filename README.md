# loyalty-bank
Same JVM microservice for Bootcamp

### How to build and test locally


The postgres docker container for running locally can be started with `docker-compose`:

`docker-compose up -d`

For local DB administration, install [pgadmin](https://www.pgadmin.org/download/)

The project also uses flyway(`resources/db/migration`) to do DB migration and it is enabled by default.

Gradle test command:

`/gradlew clean test`

Gradle build command:

`./gradlew clean build`

Run webapp locally from CLI

`/gradlew bootRun`

You can also build a docker image and run the application there, though it will need connectivity to postgres allowed

Docker build command:

`docker build -t loyalty-bank-0.1 .`

Docker run command:

`docker run -ti -p 80:80 loyalty-bank-0.1`