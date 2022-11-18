val mybatisPlus: String by System.getProperties()
val saToken: String by System.getProperties()

dependencies {
  api(project(":sub-module-sso-api"))

  compileOnly(project(":sub-system-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-validation")

  compileOnly("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")

  compileOnly("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")

  compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
  implementation("net.oschina.j2cache:j2cache-springcache:2.8.0-release") {exclude(group = "org.slf4j", module = "slf4j-simple")}
}
