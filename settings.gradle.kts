pluginManagement {
  repositories {
    maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
    maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
    jcenter()
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-model")
include("sub-netty")
include("sub-vertx")
include("sub-core")
include("sub-web")
