FROM maven:latest

EXPOSE 8080

# Build the executable jar
RUN cd /usr/src/tasks
RUN mvn package

# Execute the built jar
RUN java -jar tasks/tasks-web/target/tasks-web-1.0.jar