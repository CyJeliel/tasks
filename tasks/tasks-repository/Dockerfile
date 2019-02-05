####### WORKING ########

# create mysql instance
FROM mysql:8.0.14

# populate database with the tables need for authentication and tasks CRUD 
COPY database_load.sql /docker-entrypoint-initdb.d/database_load.sql

# expose the port outside Docker
EXPOSE 3306

# 
CMD ["mysqld"]
########## WORKING ############

# Clone source code from git

# Build the executable jar
RUN cd /Users/cindy.albuquerque/git/repository/tasks/ 
RUN  mvn package

# Execute the built jar
# java -jar tasks-web/target/tasks-web-1.0.jar