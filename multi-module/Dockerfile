FROM openjdk:8-jre-slim AS base
EXPOSE 8080
WORKDIR /app

FROM maven:3.5-jdk-8-slim AS build
WORKDIR /usr/src/app
COPY pom.xml ./
COPY app/pom.xml app/
COPY lib/pom.xml lib/
RUN /usr/local/bin/mvn-entrypoint.sh \
    mvn package dependency:copy-dependencies -Dmaven.test.skip=true -Dcheckstyle.skip=true -Dmaven.javadoc.skip=true --fail-never
COPY . .
RUN mvn package dependency:copy-dependencies -Dmaven.test.skip=true -Dcheckstyle.skip=true -Dmaven.javadoc.skip=true

FROM base AS final
COPY --from=build /usr/src/app/app/target .
ENTRYPOINT ["java","-cp","./*:./dependencies/*","Application"]