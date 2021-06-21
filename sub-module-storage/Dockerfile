FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/storage-boot.jar /lib/storage-boot.jar
COPY build/bootScripts/sub-module-storage /script/runner
CMD ./script/runner
