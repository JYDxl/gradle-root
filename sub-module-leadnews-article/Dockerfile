FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/leadnews-article-boot.jar /lib/leadnews-article-boot.jar
COPY build/bootScripts/sub-module-leadnews-article /script/runner
CMD ./script/runner
