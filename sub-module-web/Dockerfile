FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/web-boot.jar /lib/web-boot.jar
COPY build/bootScripts/sub-module-web /script/runner
CMD ./script/runner
