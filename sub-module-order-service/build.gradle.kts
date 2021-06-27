val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-core"))
  compileOnly(project(":sub-system-config"))

  api(project(":sub-module-order-model"))
  api(project(":sub-mysql-seata-order-service"))

  api(project(":sub-module-storage-api"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
//  compileOnly("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}
  compileOnly("com.alibaba.cloud:spring-cloud-starter-alibaba-seata") {exclude(group = "com.alibaba", module = "druid")}
}
