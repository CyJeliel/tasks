#!/bin/bash


cd ~/Documents/


mkdir app_tasks


cd app_tasks/


git clone https://github.com/CyJeliel/tasks.git cindy_tasks


cd cindy_tasks/tasks/tasks-repository/


docker build . -t database_tasks:latest


cd ..


docker-compose up

