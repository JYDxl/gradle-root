FROM amazoncorretto:latest
COPY build/libs/netty-boot.jar /opt/netty-boot.jar
COPY lib/libnetty_transport_native_epoll_x86_64.so /opt/lib/libnetty_transport_native_epoll_x86_64.so
WORKDIR /opt
EXPOSE 10000/tcp 5000/tcp
CMD ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5000","-Djava.library.path=/opt/lib", "-jar", "netty-boot.jar"]
