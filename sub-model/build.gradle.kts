val mybatisplus: String by System.getProperties()
val swagger: String by System.getProperties()
val mysql: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("io.springfox:springfox-boot-starter:$swagger")

  api("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  api("com.baomidou:mybatis-plus-extension:$mybatisplus")

  testImplementation("com.baomidou:mybatis-plus-generator:3.4.1")
  testImplementation("mysql:mysql-connector-java:$mysql")
  testImplementation("org.freemarker:freemarker")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
