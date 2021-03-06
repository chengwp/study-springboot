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

### 启动redis服务端方式1   指定数据存放目录与配置文件路径
docker run -d -p 6379:6379 --rm --name redis  \
-v /Users/chengweiping/develop/docker/redis/data:/data \
-v /Users/chengweiping/develop/docker/redis/conf/redis.conf:/usr/local/etc/redis/redis.conf \
 redis:latest
 ### 启动redis服务端方式2  只指定配置文件路径
 docker run -d -p 6379:6379 --rm --name redis  \
 -v /Users/chengweiping/develop/docker/redis/data:/data \
 chengweiping/redis:1.0.0
 
 ### 启动redis客户端测试连接服务端获取服务端信息 （测试服务端是否启动成功）
 docker run -it --rm --name=redis-cli goodsmileduck/redis-cli:latest redis-cli -h 127.0.0.1 -p 6379 info
 
### 启动study-web项目容器
docker run -it -p 8080:8080 --rm --name study-web --network study-net \
chengweiping/study-web:0.0.1 \
--spring.profiles.active=test /bin/bash



### 启动study-web项目容器（带环境变量方式，可以动态修改配置文件里面的变量值
docker run -it -p 8080:8080 \
-e MYSQL_HOST=127.0.0.1 \
--rm --name study-web --network study-net  \
chengweiping/study-web:0.0.1  \
--spring.profiles.active=dev   \
/bin/bash

### 搭建一个非认证方式的Docker registry（私有镜像仓库）
docker run -d -p 5000:5000 --restart=always -v /Users/chengweiping/develop/docker/registry:/var/lib/registry --name registry  registry:2.4.1

### 查询仓库镜像
curl http://192.168.10.198:5000/v2/_catalog
### 查看某个镜像的标签列表
curl http://192.168.10.198:5000/v2/chengweiping/study-web/tags/list


### 项目编译-推镜像命令
先在study-springboot目录下执行  mvn clean install 命令  进行编译安装
然后在study-web目录下执行  mvn docker:build 进行构建镜像
如果执行命令  mvn docker:build -DpushImage  进行构建进行并推送到镜像仓库
