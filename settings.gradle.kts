pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "gradle-root"

include("sub-system")
include("sub-core")

include("sub-gateway")

include("sub-admin")

include("sub-netty")

include("sub-vertx")

include("sub-client")

include("sub-mysql-web-entity")
include("sub-mysql-web-service")

include("sub-web-service")
include("sub-web-model")
include("sub-web-api")
include("sub-web")

include("sub-auth-service")
include("sub-auth-model")
include("sub-auth-api")
include("sub-auth")

include("sub-shop-service")
include("sub-shop-model")
include("sub-shop-api")
include("sub-shop")
