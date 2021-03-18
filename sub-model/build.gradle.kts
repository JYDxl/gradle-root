val mybatisplus: String by System.getProperties()
val mysql: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot")

  api("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  api("com.baomidou:mybatis-plus-extension:$mybatisplus")

  testImplementation("com.baomidou:mybatis-plus-generator:3.4.1")
  testImplementation("mysql:mysql-connector-java:$mysql")
  testImplementation("org.freemarker:freemarker")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
