FROM jre-alpine
COPY build/libs/gateway-boot.jar /lib/gateway-boot.jar
COPY build/bootScripts/sub-gateway /script/runner
CMD ./script/runner
