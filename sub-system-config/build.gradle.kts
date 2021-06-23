val mybatisPlus: String by System.getProperties()
val shiroRedis: String by System.getProperties()
val swagger: String by System.getProperties()
val shiro: String by System.getProperties()

dependencies {
  api(project(":sub-module-hub-api"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")

  compileOnly("io.springfox:springfox-boot-starter:$swagger")
  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

  compileOnly("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")

  compileOnly("org.crazycake:shiro-redis-spring-boot-starter:$shiroRedis") {
    exclude(group = "org.apache.maven.plugins")
    exclude(group = "redis.clients")
  }

  compileOnly("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")

  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")
}
