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

include("sub-mysql-mydb-entity")
include("sub-mysql-mydb-service")

include("sub-mysql-seata-account-entity")
include("sub-mysql-seata-account-service")

include("sub-mysql-seata-order-entity")
include("sub-mysql-seata-order-service")

include("sub-mysql-seata-storage-entity")
include("sub-mysql-seata-storage-service")

include("sub-web-service")
include("sub-web-model")
include("sub-web-api")
include("sub-web")

include("sub-hub-service")
include("sub-hub-model")
include("sub-hub-api")
include("sub-hub")

include("sub-shop-service")
include("sub-shop-model")
include("sub-shop-api")
include("sub-shop")

include("sub-account-service")
include("sub-account-model")
include("sub-account-api")
include("sub-account")

include("sub-order-service")
include("sub-order-model")
include("sub-order-api")
include("sub-order")

include("sub-storage-service")
include("sub-storage-model")
include("sub-storage-api")
include("sub-storage")
