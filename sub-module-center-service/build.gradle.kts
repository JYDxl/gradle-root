val jetcache: String by System.getProperties()
val saToken: String by System.getProperties()

dependencies {
  api(project(":sub-module-center-dto"))
  api(project(":sub-mysql-center-service"))

  compileOnly(project(":sub-system-core"))
  compileOnly(project(":sub-system-common"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
  compileOnly("jakarta.validation:jakarta.validation-api")
  compileOnly("com.alicp.jetcache:jetcache-starter-redis-lettuce:$jetcache") {exclude(group = "com.alibaba.fastjson2")}
}
