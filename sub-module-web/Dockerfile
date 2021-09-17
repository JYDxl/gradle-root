FROM bitnami/java
COPY build/libs/web-boot.jar /lib/web-boot.jar
COPY build/bootScripts/sub-module-web /script/runner
CMD ./script/runner
