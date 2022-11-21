val jetcache: String by System.getProperties()
val saToken: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-core"))

  api(project(":sub-module-web-dto"))

  api(project(":sub-mysql-sccore-service"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
  compileOnly("com.alicp.jetcache:jetcache-starter-redis-lettuce:$jetcache")
//  compileOnly("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}
}
