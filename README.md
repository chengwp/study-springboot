# 项目docker环境搭建

### 新建一个容器内部网络
docker network create -d bridge study-net

### 启动mysql容器
docker run -it -p 3306:3306 --rm --name mysql --network study-net  \
-v /Users/chengweiping/develop/docker/mysql/conf:/etc/mysql \
-v /Users/chengweiping/develop/docker/mysql/logs:/var/log/mysql \
-v /Users/chengweiping/develop/docker/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:5.7

### 启动study-web项目容器
docker run -it -p 8080:8080 --rm --name study-web --network study-net \
study-web:0.0.1-SNAPSHOT \
--spring.profiles.active=test /bin/bash
