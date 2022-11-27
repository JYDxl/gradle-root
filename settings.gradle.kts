pluginManagement {
  repositories {
    maven {url = uri("https://maven.aliyun.com/repository/gradle-plugin")}
    maven {url = uri("https://maven.aliyun.com/repository/spring-plugin")}
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-system-core")

include("sub-system-common")

include("sub-cloud-gateway")

include("sub-cloud-admin")

include("sub-single-netty")

include("sub-single-vertx")

include("sub-mysql-mydb-entity")
include("sub-mysql-mydb-service")

include("sub-mysql-sccore-entity")
include("sub-mysql-sccore-service")

include("sub-module-web-service")
include("sub-module-web-dto")
include("sub-module-web-api")
include("sub-module-web")

include("sub-module-center-service")
include("sub-module-center-dto")
include("sub-module-center-api")
include("sub-module-center")

include("sub-module-net")
