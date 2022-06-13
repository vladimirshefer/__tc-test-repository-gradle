FROM openjdk:17
EXPOSE 8881
ARG JAR_FILE=build/libs/alfa_test-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]