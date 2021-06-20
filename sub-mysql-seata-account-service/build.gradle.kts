val mybatisplus: String by System.getProperties()
val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-core"))
  compileOnly(project(":sub-system"))

  compileOnly("org.springframework.boot:spring-boot-starter")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

  api("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  api("com.baomidou:mybatis-plus-extension:$mybatisplus")

  api(project(":sub-mysql-seata-account-entity"))
}
