val mybatisplus: String by System.getProperties()
val swagger: String by System.getProperties()

dependencies {
  api(project(":sub-mysql-web"))

  compileOnly(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("io.springfox:springfox-boot-starter:$swagger")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
