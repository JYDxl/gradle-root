pluginManagement {
  repositories {
    maven {url = uri("https://maven.aliyun.com/repository/gradle-plugin")}
    maven {url = uri("https://maven.aliyun.com/repository/spring-plugin")}
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-system-core")

include("sub-system-sso")

include("sub-system-common")

include("sub-cloud-gateway")

include("sub-cloud-admin")

include("sub-module-netty")

include("sub-module-vertx")

include("sub-mysql-center-entity")
include("sub-mysql-center-service")

include("sub-mysql-course-entity")
include("sub-mysql-course-service")

include("sub-mysql-blog-entity")
include("sub-mysql-blog-service")

include("sub-module-web-service")
include("sub-module-web-dto")
include("sub-module-web-api")
include("sub-module-web")

include("sub-module-blog-service")
include("sub-module-blog-dto")
include("sub-module-blog-api")
include("sub-module-blog")

include("sub-module-center-service")
include("sub-module-center-dict")
include("sub-module-center-dto")
include("sub-module-center-api")
include("sub-module-center")
