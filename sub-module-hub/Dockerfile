FROM bitnami/java
COPY build/libs/hub-boot.jar /lib/hub-boot.jar
COPY build/bootScripts/sub-module-hub /script/runner
CMD ./script/runner
