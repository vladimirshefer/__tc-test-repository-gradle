FROM openjdk:17
EXPOSE 8881
ENV GIPHY_API_KEY=mM4Nx6aNFvYBVe0IcYSAGoR1yqfrcKGb \
    OPENEXCHANGE_API_KEY=8b535cfe854d4b2ab1d7c28b7b007118
ARG JAR_FILE=build/libs/alfa_test-0.0.1.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar","-Dspring.profiles.active=prod"]