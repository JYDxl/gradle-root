FROM azul/zulu-openjdk-alpine:17.0.5-jre-headless

RUN apk add tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata

COPY build/libs/admin-boot.jar /lib/admin-boot.jar
COPY build/bootScripts/sub-cloud-admin /script/runner
CMD ./script/runner

EXPOSE 8080 5005
