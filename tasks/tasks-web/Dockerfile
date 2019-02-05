FROM mysql:8.0.14

COPY database_load.sql /docker-entrypoint-initdb.d/database_load.sql

EXPOSE 3306

CMD ["mysqld"]
