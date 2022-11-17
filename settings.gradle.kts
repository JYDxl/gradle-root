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

include("sub-mysql-mydb-entity")
include("sub-mysql-mydb-service")

include("sub-mysql-sccore-entity")
include("sub-mysql-sccore-service")

include("sub-module-web-service")
include("sub-module-web-dto")
include("sub-module-web-api")
include("sub-module-web")

include("sub-module-sso-service")
include("sub-module-sso-dto")
include("sub-module-sso-api")
include("sub-module-sso")

include("sub-module-hub-service")
include("sub-module-hub-dto")
include("sub-module-hub-api")
include("sub-module-hub")

include("sub-module-net")
