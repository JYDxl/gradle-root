FROM alpine-jre
COPY build/libs/netty-boot.jar /lib/netty-boot.jar
COPY build/scriptsShadow/sub-netty /runner
EXPOSE 10000/tcp 5005/tcp
CMD ./runner
