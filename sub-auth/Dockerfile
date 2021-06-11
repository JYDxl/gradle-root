FROM jre-alpine
RUN apk add tomcat-native && rm -rf /var/cache/apk/*
COPY build/libs/auth-boot.jar /lib/auth-boot.jar
COPY build/bootScripts/sub-auth /script/runner
CMD ./script/runner
