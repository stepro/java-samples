FROM openjdk:8-jre-slim AS base
EXPOSE 8080
WORKDIR /app

FROM maven:3.5-jdk-8-slim AS build
WORKDIR /usr/src/app
COPY pom.xml .
RUN /usr/local/bin/mvn-entrypoint.sh \
    mvn package -Dmaven.test.skip=true --fail-never
COPY . .
RUN mvn package -Dmaven.test.skip=true

FROM base AS final
COPY --from=build /usr/src/app/target/a-module-0.1.0-jar-with-dependencies.jar .
ENTRYPOINT ["java", "-jar", "a-module-0.1.0-jar-with-dependencies.jar"]