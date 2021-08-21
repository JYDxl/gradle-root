pluginManagement {
  repositories {
    maven {url = uri("https://maven.aliyun.com/repository/gradle-plugin")}
    maven {url = uri("https://maven.aliyun.com/repository/spring-plugin")}
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-system-core")

include("sub-system-config")

include("sub-cloud-gateway")

include("sub-cloud-admin")

include("sub-single-netty")

include("sub-single-vertx")

include("sub-single-flink")

include("sub-mysql-mydb-entity")
include("sub-mysql-mydb-service")

include("sub-mysql-blog-entity")
include("sub-mysql-blog-service")

include("sub-module-web-service")
include("sub-module-web-dto")
include("sub-module-web-api")
include("sub-module-web")

include("sub-module-hub-service")
include("sub-module-hub-dto")
include("sub-module-hub-api")
include("sub-module-hub")

include("sub-module-blog-service")
include("sub-module-blog-dto")
include("sub-module-blog-api")
include("sub-module-blog")
