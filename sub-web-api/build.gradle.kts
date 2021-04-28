val mybatisplus: String by System.getProperties()
val shiro: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))
  implementation(project(":sub-web-model"))
  implementation(project(":sub-web-service"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
  compileOnly("org.hibernate.validator:hibernate-validator")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
}
