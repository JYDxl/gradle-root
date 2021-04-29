FROM jre-alpine
RUN apk add tomcat-native
RUN apk cache clean
COPY build/libs/web-boot.jar /lib/web-boot.jar
COPY build/bootScripts/sub-web /script/runner
CMD ./script/runner
