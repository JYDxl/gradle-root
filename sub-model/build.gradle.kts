val mybatisplus: String by System.getProperties()
val mysql: String by System.getProperties()

dependencies {
  api(project(":sub-core"))

  compileOnly("com.fasterxml.jackson.core:jackson-databind")
  compileOnly("org.springframework.boot:spring-boot")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisplus")

  testImplementation("com.baomidou:mybatis-plus-generator:$mybatisplus")
  testImplementation("mysql:mysql-connector-java:$mysql")
  testImplementation("org.freemarker:freemarker")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
