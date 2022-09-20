FROM maven:3-openjdk-11-slim AS build-stage

WORKDIR /build

COPY .. /build

RUN mvn clean package


FROM openjdk:11 AS production-stage

WORKDIR /usr/app

COPY --from=build-stage /build/target/rest_server.jar .

ENV PORT 8080
EXPOSE $PORT

CMD [ "java", "-jar", "rest_server.jar" ]
