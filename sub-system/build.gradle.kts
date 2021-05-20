val shiroredis: String by System.getProperties()
val shiro: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")

  compileOnly("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")

  compileOnly("org.crazycake:shiro-redis-spring-boot-starter:$shiroredis") {exclude(group = "redis.clients")}
}
