val mybatisplus: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))
  implementation(project(":sub-model"))
  implementation(project(":sub-web-service"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
}
