FROM java:8

VOLUME /tmp

RUN mkdir /app

ADD study-web-0.0.1.jar /app/app.jar

RUN bash -c "touch /app/app.jar"

WORKDIR /app

EXPOSE 8080

CMD  java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom  -jar  /app/app.jar  \

--spring.profiles.active=$ENV
