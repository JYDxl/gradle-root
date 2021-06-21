FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/order-boot.jar /lib/order-boot.jar
COPY build/bootScripts/sub-module-order /script/runner
CMD ./script/runner
