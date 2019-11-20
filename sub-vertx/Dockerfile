#FROM azul/zulu-openjdk-alpine:11-jre as gradle-vertx
#
#RUN \
##设置镜像地址
#    sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories \
#    && apk update \
##安装常用工具包
#    && apk add curl tree iproute2 \
##设置时区
#    && apk add -U tzdata \
#    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
#    && echo 'Asia/Shanghai' > /etc/timezone \
##配置netty-native文件
#    && mkdir -p /opt/tmp/netty/ \
#    && cd /opt/tmp/netty/ \
#    && wget https://maven.aliyun.com/repository/public/io/netty/netty-all/4.1.43.Final/netty-all-4.1.43.Final.jar \
#    && unzip netty-all-4.1.43.Final.jar \
#    && mkdir /opt/native/ \
#    && cp META-INF/native/libnetty_transport_native_epoll_x86_64.so /opt/native/ \
##文件清理
#    && cd /opt/ \
#    && rm -rf /opt/tmp
##配置环境
#ENV LANGUAGE en_US.UTF-8
#ENV TZ Asia/Shanghai

FROM gradle-vertx
COPY build/libs/vertx-boot.jar /opt/vertx-boot.jar
WORKDIR /opt
EXPOSE 3000/tcp 8800/tcp 5005/tcp
CMD java \
    -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 \
    -ea \
    -jar \
    -Djava.library.path=/opt/native \
    -Dio.netty.tryReflectionSetAccessible=true \
    --add-exports=java.base/sun.nio.ch=ALL-UNNAMED \
    --add-opens=java.base/java.nio=ALL-UNNAMED \
    --add-exports=java.base/jdk.internal.misc=ALL-UNNAMED \
    --illegal-access=deny \
    vertx-boot.jar
