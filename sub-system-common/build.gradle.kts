val mybatisPlus: String by System.getProperties()
val jetcache: String by System.getProperties()
val saToken: String by System.getProperties()
val forest: String by System.getProperties()

dependencies {
  api(project(":sub-module-center-api"))
  api(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  implementation("com.dtflys.forest:forest-spring-boot-starter:$forest")

  compileOnly("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")

  compileOnly("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")

  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
  compileOnly("com.alicp.jetcache:jetcache-starter-redis-lettuce:$jetcache")
}
