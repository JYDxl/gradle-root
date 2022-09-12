FROM azul/zulu-openjdk-alpine:17.0.4.1-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

COPY build/libs/netty-boot.jar /lib/netty-boot.jar
COPY build/scriptsShadow/sub-netty /script/runner
CMD ./script/runner

EXPOSE 8080 5005
