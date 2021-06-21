FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/shop-boot.jar /lib/shop-boot.jar
COPY build/bootScripts/sub-module-shop /script/runner
CMD ./script/runner
