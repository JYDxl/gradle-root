val mybatisPlus: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-core"))
  compileOnly(project(":sub-system-config"))

  compileOnly("org.springframework.boot:spring-boot-starter")

  api("com.baomidou:mybatis-plus-annotation:$mybatisPlus")
  api("com.baomidou:mybatis-plus-extension:$mybatisPlus")

  api(project(":sub-mysql-sccore-entity"))
}
