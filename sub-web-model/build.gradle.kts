val mybatisplus: String by System.getProperties()
val swagger: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("io.springfox:springfox-boot-starter:$swagger")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")

  api("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  api("com.baomidou:mybatis-plus-extension:$mybatisplus")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
