pluginManagement {
  repositories {
    maven { url = uri("http://maven.aliyun.com/repository/gradle-plugin");isAllowInsecureProtocol = true }
    maven { url = uri("http://maven.aliyun.com/repository/spring-plugin");isAllowInsecureProtocol = true }
    jcenter()
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-model")
include("sub-netty")
include("sub-vertx")
include("sub-core")

include("sub-web-eureka")
include("sub-web-admin")
include("sub-web-service")
include("sub-web-api")
include("sub-web")
