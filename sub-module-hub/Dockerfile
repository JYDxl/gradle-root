FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/hub-boot.jar /lib/hub-boot.jar
COPY build/bootScripts/sub-hub /script/runner
CMD ./script/runner
