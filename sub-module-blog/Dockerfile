FROM azul/zulu-openjdk-alpine:17.0.1-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/blog-boot.jar /lib/blog-boot.jar
COPY build/bootScripts/sub-module-blog /script/runner
CMD ./script/runner

EXPOSE 8080 5005
