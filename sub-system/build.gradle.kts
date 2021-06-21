val mybatisplus: String by System.getProperties()
val shiroredis: String by System.getProperties()
val swagger: String by System.getProperties()
val shiro: String by System.getProperties()

dependencies {
  api(project(":sub-hub-api"))

  compileOnly(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")

  compileOnly("io.springfox:springfox-boot-starter:$swagger")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

  compileOnly("com.baomidou:mybatis-plus-boot-starter:$mybatisplus")

  compileOnly("org.crazycake:shiro-redis-spring-boot-starter:$shiroredis") {
    exclude(group = "org.apache.maven.plugins")
    exclude(group = "redis.clients")
  }

  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
}
