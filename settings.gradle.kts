pluginManagement {
  repositories {
    maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
    maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"
include("sub-security")
include("sub-config")
include("sub-core")
include("sub-web")
include("sub-model")
include("sub-netty")
include("sub-vertx")
