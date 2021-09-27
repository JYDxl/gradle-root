FROM azul/zulu-openjdk-alpine:11-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

COPY build/libs/web-boot.jar /lib/web-boot.jar
COPY build/bootScripts/sub-module-web /script/runner
CMD ./script/runner
