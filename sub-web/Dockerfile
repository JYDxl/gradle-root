FROM jre-alpine

RUN  apk add tomcat-native

COPY build/libs/web-boot.jar /web-boot.jar

ENTRYPOINT [ \
"java","-jar", "web-boot.jar", \
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", \
    "-ea", \
    "-Djava.library.path=/usr/lib", \
    "-Dio.netty.tryReflectionSetAccessible=true", \
    "-Dio.netty.leakDetection.level=advanced", \
    "-Djava.net.preferIPv4Stack=true", \
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED", \
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED", \
    "--add-opens=java.base/java.nio=ALL-UNNAMED", \
    "--eureka.instance.hostname=ubuntu" \
]
