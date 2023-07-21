FROM gradle:8.1.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM ghcr.io/graalvm/jdk-community:17-ol9

EXPOSE 8080

COPY --from=build /home/gradle/src/build/libs/*.jar spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","spring-boot-application.jar"]