FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/blog-boot.jar /lib/blog-boot.jar
COPY build/bootScripts/sub-module-blog /script/runner
CMD ./script/runner
