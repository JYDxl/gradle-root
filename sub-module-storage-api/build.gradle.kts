val shiro: String by System.getProperties()

dependencies {
  api(project(":sub-module-storage-model"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
//  compileOnly("org.hibernate.validator:hibernate-validator")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

//  compileOnly("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}
}
