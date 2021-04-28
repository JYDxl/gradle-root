pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-core")

include("sub-netty")

include("sub-vertx")

include("sub-eureka")

include("sub-admin")

include("sub-web-model")
include("sub-web-service")
include("sub-web-api")
include("sub-web")
