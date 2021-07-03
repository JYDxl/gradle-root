FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/leadnews-boot.jar /lib/leadnews-boot.jar
COPY build/bootScripts/sub-module-leadnews /script/runner
CMD ./script/runner
