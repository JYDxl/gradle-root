val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-core"))
  compileOnly(project(":sub-system"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

  api(project(":sub-mysql-web-entity"))
}
