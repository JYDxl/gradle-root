dependencies {
  api(project(":sub-module-blog-dto"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
}
