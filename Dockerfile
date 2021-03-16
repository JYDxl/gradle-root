FROM azul/zulu-openjdk-alpine:11.0.10-11.45.27-jre-headless as jre-alpine

RUN \
#设置镜像地址
    sed -i 's/dl-cdn.alpinelinux.org/mirrors.ustc.edu.cn/g' /etc/apk/repositories \
    && apk update \
    && apk upgrade \
#安装常用工具包
#    && apk add curl tree bash iproute2 \
#设置时区
    && apk add -U tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo 'Asia/Shanghai' > /etc/timezone \
    && apk cache \
#配置环境
ENV LANGUAGE en_US.UTF-8
ENV TZ Asia/Shanghai
