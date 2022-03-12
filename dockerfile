FROM gcr.io/distroless/java17-debian11
WORKDIR /
ADD target/clean-code-jorunal-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8090
CMD java -jar -Dspring.profiles.active=prod app.jar