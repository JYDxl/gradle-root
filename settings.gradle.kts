pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

rootProject.name = "gradle-root"

include("sub-core")

include("sub-system")

include("sub-gateway")

include("sub-admin")

include("sub-netty")

include("sub-vertx")

include("sub-client")

include("sub-mysql-mydb-entity")
include("sub-mysql-mydb-service")

include("sub-web-service")
include("sub-web-model")
include("sub-web-api")
include("sub-web")

include("sub-shop-service")
include("sub-shop-model")
include("sub-shop-api")
include("sub-shop")
