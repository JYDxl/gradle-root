pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-system")
include("sub-core")

include("sub-mysql-web-entity")
include("sub-mysql-web-mapper")

include("sub-gateway")

include("sub-admin")

include("sub-netty")

include("sub-vertx")

include("sub-client")

include("sub-web-service")
include("sub-web-model")
include("sub-web-api")
include("sub-web")
