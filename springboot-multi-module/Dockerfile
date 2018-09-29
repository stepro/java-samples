FROM openjdk:8-jre-slim AS base
EXPOSE 8080
WORKDIR /app

FROM maven:3.5-jdk-8-slim AS build
WORKDIR /usr/src/app
COPY pom.xml ./
COPY multiple-module-entity/pom.xml multiple-module-entity/
COPY multiple-module-service/pom.xml multiple-module-service/
COPY multiple-module-web/pom.xml multiple-module-web/
RUN /usr/local/bin/mvn-entrypoint.sh \
    mvn package -Dmaven.test.skip=true -Dcheckstyle.skip=true -Dmaven.javadoc.skip=true --fail-never
COPY . .
RUN mvn package -Dmaven.test.skip=true -Dcheckstyle.skip=true -Dmaven.javadoc.skip=true

FROM base AS final
COPY --from=build /usr/src/app/multiple-module-web/target/*.jar ./
ENTRYPOINT ["java","-jar","multiple-module-web-0.0.1-SNAPSHOT.jar"]