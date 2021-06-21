FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/account-boot.jar /lib/account-boot.jar
COPY build/bootScripts/sub-account /script/runner
CMD ./script/runner
