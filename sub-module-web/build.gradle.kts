import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

val activeProfiles: String by System.getProperties()
val serverAddr: String by System.getProperties()

application {
  mainClass.set("org.github.WebKt")
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",

    "-ea",

    "-Dspring.profiles.active=$activeProfiles",
    "-Dspring.cloud.nacos.discovery.server-addr=$serverAddr",

    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true",

    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED",
    "--add-opens=java.base/java.util=ALL-UNNAMED",
    "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
    "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
    "--add-opens=java.base/java.lang=ALL-UNNAMED",
    "--add-opens=java.base/java.math=ALL-UNNAMED",
    "--add-opens=java.base/java.text=ALL-UNNAMED",
    "--add-opens=java.base/java.time=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED",
    "--add-opens=java.base/java.net=ALL-UNNAMED"
  )
}

tasks.withType<BootJar> {
  archiveFileName.set("web-boot.jar")
}

tasks.withType<Test> {
  enabled = false
}

tasks.getByName<Task>("jar") {enabled = false}
tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

val commonsPool2: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val shiroRedis: String by System.getProperties()
val retrofit: String by System.getProperties()
val redisson: String by System.getProperties()
val swagger: String by System.getProperties()
val okhttp3: String by System.getProperties()
val mysql: String by System.getProperties()
val p6spy: String by System.getProperties()
val netty: String by System.getProperties()
val shiro: String by System.getProperties()
val jedis: String by System.getProperties()
val seata: String by System.getProperties()
val nacos: String by System.getProperties()
val jwt: String by System.getProperties()

dependencies {
  implementation(project(":sub-system-config"))
  implementation(project(":sub-system-core"))

  implementation(project(":sub-module-web-service"))

  implementation("io.netty:netty-all:$netty")

  implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")
  implementation("org.apache.commons:commons-pool2:$commonsPool2")
  implementation("com.squareup.retrofit2:retrofit:$retrofit")
  implementation("com.squareup.okhttp3:okhttp:$okhttp3")
  implementation("mysql:mysql-connector-java:$mysql")
  implementation("io.netty:netty-all:$netty")
  implementation("p6spy:p6spy:$p6spy")
  implementation("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
  implementation("com.auth0:java-jwt:$jwt")
  implementation("org.crazycake:shiro-redis-spring-boot-starter:$shiroRedis") {
    exclude(group = "org.apache.maven.plugins")
    exclude(group = "redis.clients")
  }
  implementation("redis.clients:jedis:$jedis")
  implementation("io.springfox:springfox-boot-starter:$swagger")

  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-amqp")
  implementation("org.springframework.boot:spring-boot-starter-cache")
  implementation("org.springframework.boot:spring-boot-starter-aop")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-websocket")
  implementation("org.springframework.boot:spring-boot-starter-data-redis") {exclude(group = "io.netty")}
  implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch") {exclude(group = "io.netty")}

  implementation("org.springframework.kafka:spring-kafka") {exclude(group = "io.netty")}

  implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
  implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")
  implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

  implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
  implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")

  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
  implementation("com.alibaba.nacos:nacos-client:$nacos")
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel") {exclude(group = "io.netty")}
  implementation("com.alibaba.csp:sentinel-datasource-nacos")
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-seata") {exclude(group = "com.alibaba", module = "druid")}
  implementation("io.seata:seata-spring-boot-starter:$seata") {exclude(group = "com.alibaba", module = "druid")}
//  implementation("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}

  developmentOnly("org.springframework.boot:spring-boot-devtools")

  testImplementation("org.springframework.kafka:spring-kafka-test") {exclude(group = "io.netty")}
//  testImplementation("org.springframework.security:spring-security-test")
//  implementation("org.redisson:redisson:$redisson") {exclude(group = "io.netty")}
}
