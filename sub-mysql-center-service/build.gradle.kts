val mybatisPlus: String by System.getProperties()

dependencies {
  api(project(":sub-mysql-center-entity"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter")

  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")
}
