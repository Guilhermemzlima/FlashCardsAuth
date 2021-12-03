FROM adoptopenjdk/openjdk11:debian-slim as build

RUN mkdir /auth

WORKDIR /auth

COPY . .

RUN ./gradlew clean build bootJar

FROM adoptopenjdk/openjdk11:debian-slim

COPY --from=build /auth/build/libs/auth-0.0.1-SNAPSHOT.jar /app/auth.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "/app/auth.jar"]
