dependencies {
  api(project(":sub-module-center-dto"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
//  compileOnly("org.hibernate.validator:hibernate-validator")

//  compileOnly("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}
}
