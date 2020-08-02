FROM alpine-jre
COPY build/libs/vertx-boot.jar /lib/vertx-boot.jar
COPY build/scriptsShadow/sub-vertx /runner
EXPOSE 3000/tcp 10000/tcp 5005/tcp
CMD ./runner
