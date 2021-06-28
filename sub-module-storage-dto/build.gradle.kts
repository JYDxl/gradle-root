val mybatisPlus: String by System.getProperties()
val swagger: String by System.getProperties()

dependencies {
  api(project(":sub-mysql-seata-storage-entity"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("io.springfox:springfox-boot-starter:$swagger")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisPlus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")
}
