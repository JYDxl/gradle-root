FROM azul/zulu-openjdk-alpine:17.0.5-17.38.21-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

COPY build/libs/center-boot.jar /app/lib/center-boot.jar
COPY build/bootScripts/sub-module-center /app/script/runner
CMD ./app/script/runner

EXPOSE 19001 15001
