val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system"))
  compileOnly(project(":sub-core"))

  api(project(":sub-auth-api"))
  api(project(":sub-auth-model"))
  api(project(":sub-mysql-web-service"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")
//  compileOnly("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}
}
