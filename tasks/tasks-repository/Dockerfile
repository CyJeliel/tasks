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