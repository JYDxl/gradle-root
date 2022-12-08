val jetcache: String by System.getProperties()
val saToken: String by System.getProperties()

dependencies {
  api(project(":sub-module-web-dto"))
  api(project(":sub-mysql-course-service"))
  api(project(":sub-module-center-api"))

  compileOnly(project(":sub-system-core"))
  compileOnly(project(":sub-system-common"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("jakarta.validation:jakarta.validation-api")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
  compileOnly("com.alicp.jetcache:jetcache-starter-redis-lettuce:$jetcache")
}
