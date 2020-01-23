
FROM java:8-jdk-alpine

COPY ./target/scrambled-words-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/
COPY ./dict.txt /usr/app/
COPY ./input.txt /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "scrambled-words-1.0-SNAPSHOT-jar-with-dependencies.jar", "./dict.txt", "./input.txt"]
