val shiroredis: String by System.getProperties()
val shiro: String by System.getProperties()

dependencies {
  api(project(":sub-auth-api"))

  compileOnly(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")

  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

  compileOnly("org.crazycake:shiro-redis-spring-boot-starter:$shiroredis") {
    exclude(group = "org.apache.maven.plugins")
    exclude(group = "redis.clients")
  }
}
