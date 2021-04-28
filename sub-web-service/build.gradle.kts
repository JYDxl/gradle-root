dependencies {
  implementation(project(":sub-core"))
  implementation(project(":sub-web-model"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.springframework.boot:spring-boot-starter-jdbc")
  compileOnly("javax.servlet:javax.servlet-api")
}
