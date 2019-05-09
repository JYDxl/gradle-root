pluginManagement {
  repositories {
    maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
    maven { url = uri("https://maven.aliyun.com/repository/spring-plugin") }
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"
include("sub-coroutines")
include("sub-javassist")
include("sub-security")
include("sub-byteman")
include("sub-config")
include("sub-rxjava")
include("sub-model")
include("sub-netty")
include("sub-vertx")
include("sub-guice")
include("sub-core")
include("sub-web")
include("sub-jna")
