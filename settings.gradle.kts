pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-system")
include("sub-core")
include("sub-api")

include("sub-gateway")

include("sub-admin")

include("sub-netty")

include("sub-vertx")

include("sub-client")

include("sub-web-service")
include("sub-web-model")
include("sub-web-api")
include("sub-web")
