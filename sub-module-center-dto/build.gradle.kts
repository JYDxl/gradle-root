val mybatisPlus: String by System.getProperties()

dependencies {
  api(project(":sub-mysql-center-entity"))

  compileOnly(project(":sub-system-core"))

  compileOnly("javax.servlet:javax.servlet-api")
  compileOnly("org.springframework.boot:spring-boot")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("org.springframework.boot:spring-boot-starter-data-mongodb")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisPlus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")
}
