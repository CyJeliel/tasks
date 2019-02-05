FROM maven:latest

EXPOSE 8080

COPY . /usr/src/tasks

# Build the executable jar
RUN mvn package -f /usr/src/tasks

# Execute the built jar
RUN java -jar tasks/tasks-web/target/tasks-web-1.0.jar