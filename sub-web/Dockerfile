FROM jre-alpine
RUN apk add tomcat-native
RUN rm -rf /var/cache/apk/*
COPY build/libs/web-boot.jar /lib/web-boot.jar
COPY build/bootScripts/sub-web /script/runner
CMD ./script/runner
