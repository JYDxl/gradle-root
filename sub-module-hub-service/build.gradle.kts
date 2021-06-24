val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-config"))
  compileOnly(project(":sub-system-core"))

  api(project(":sub-module-hub-model"))
  api(project(":sub-mysql-mydb-service"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
//  compileOnly("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}
}