pluginManagement {
  repositories {
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
