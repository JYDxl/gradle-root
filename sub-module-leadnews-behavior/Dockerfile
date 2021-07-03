FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/leadnews-behavior-boot.jar /lib/leadnews-behavior-boot.jar
COPY build/bootScripts/sub-module-leadnews-behavior /script/runner
CMD ./script/runner
