FROM azul/zulu-openjdk-alpine:17-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

COPY build/libs/net-boot.jar /lib/net-boot.jar
COPY build/bootScripts/sub-module-net /script/runner
CMD ./script/runner

EXPOSE 10000
