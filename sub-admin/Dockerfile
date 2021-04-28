FROM jre-alpine

COPY build/libs/admin.jar /admin.jar

ENTRYPOINT [ \
"java","-jar", "admin.jar", \
    "-ea", \
    "--spring.application.name=admin-server", \
    "--eureka.instance.hostname=ubuntu" \
]
