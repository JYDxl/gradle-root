FROM azul/zulu-openjdk-alpine:17.0.5-17.38.21-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

COPY build/libs/vertx-boot.jar /lib/vertx-boot.jar
COPY build/scriptsShadow/sub-vertx /script/runner
CMD ./script/runner

EXPOSE 19005 15005
