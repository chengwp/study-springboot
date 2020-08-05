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

### 搭建一个非认证方式的Docker registry（私有镜像仓库）
docker run -d -p 5000:5000 --restart=always -v /Users/chengweiping/develop/docker/registry:/var/lib/registry --name registry  registry:2.4.1

### 查询仓库镜像
curl http://192.168.10.198:5000/v2/_catalog
### 查看某个镜像的标签列表
curl http://192.168.10.198:5000/v2/study-web/tags/list


### 项目编译-推镜像命令
先在study-springboot目录下执行  mvn clean install 命令  进行编译安装
然后在study-web目录下执行  mvn docker:build 进行构建镜像
如果执行命令  mvn docker:build -DpushImage  进行构建进行并推送到镜像仓库
