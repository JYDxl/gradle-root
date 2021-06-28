pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

rootProject.name = "gradle-root"

include("sub-system-core")

include("sub-system-config")

include("sub-cloud-gateway")

include("sub-cloud-admin")

include("sub-single-netty")

include("sub-single-vertx")

include("sub-mysql-mydb-entity")
include("sub-mysql-mydb-service")

include("sub-mysql-seata-account-entity")
include("sub-mysql-seata-account-service")

include("sub-mysql-seata-order-entity")
include("sub-mysql-seata-order-service")

include("sub-mysql-seata-storage-entity")
include("sub-mysql-seata-storage-service")

include("sub-postgresql-runoobdb-entity")
include("sub-postgresql-runoobdb-service")

include("sub-module-web-service")
include("sub-module-web-dto")
include("sub-module-web-api")
include("sub-module-web")

include("sub-module-hub-service")
include("sub-module-hub-dto")
include("sub-module-hub-api")
include("sub-module-hub")

include("sub-module-shop-service")
include("sub-module-shop-dto")
include("sub-module-shop-api")
include("sub-module-shop")

include("sub-module-account-service")
include("sub-module-account-dto")
include("sub-module-account-api")
include("sub-module-account")

include("sub-module-order-service")
include("sub-module-order-dto")
include("sub-module-order-api")
include("sub-module-order")

include("sub-module-storage-service")
include("sub-module-storage-dto")
include("sub-module-storage-api")
include("sub-module-storage")
