val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-core"))

  api(project(":sub-web-model"))
  api(project(":sub-mysql-web-service"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
}
