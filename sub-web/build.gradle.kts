import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

application {
  mainClass.set("org.github.WebKt")
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",
    "-ea",
    "-Djava.library.path=/usr/lib",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true",
    "--illegal-access=deny"
  )
}

tasks.withType<BootJar> {
  archiveFileName.set("web-boot.jar")
}

tasks.withType<Test> {
  enabled = false
}

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

val commonspool2: String by System.getProperties()
val mybatisplus: String by System.getProperties()
val retrofit: String by System.getProperties()
val redisson: String by System.getProperties()
val swagger: String by System.getProperties()
val okhttp3: String by System.getProperties()
val mysql: String by System.getProperties()
val p6spy: String by System.getProperties()
val netty: String by System.getProperties()
val shiro: String by System.getProperties()
val jwt: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))
  implementation(project(":sub-api"))

  implementation(project(":sub-web-service"))
  implementation(project(":sub-web-model"))
  implementation(project(":sub-web-api"))

  api("io.netty:netty-all:$netty")
  api("io.vertx:vertx-web") {exclude(group = "io.netty")}
  api("io.vertx:vertx-web-client") {exclude(group = "io.netty")}
  api("io.vertx:vertx-lang-kotlin") {exclude(group = "io.netty")}
  api("io.vertx:vertx-lang-kotlin-coroutines") {exclude(group = "io.netty")}

  implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisplus")
  implementation("org.apache.commons:commons-pool2:$commonspool2")
  implementation("com.squareup.retrofit2:retrofit:$retrofit")
  implementation("com.squareup.okhttp3:okhttp:$okhttp3")
  implementation("mysql:mysql-connector-java:$mysql")
  implementation("io.netty:netty-all:$netty")
  implementation("p6spy:p6spy:$p6spy")
  implementation("org.apache.shiro:shiro-spring-boot-web-starter:$shiro")
  implementation("com.auth0:java-jwt:$jwt")
  implementation("org.crazycake:shiro-redis-spring-boot-starter:3.3.1")
  implementation("redis.clients:jedis:3.6.0")
  implementation("io.springfox:springfox-boot-starter:$swagger")

  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//  implementation("org.springframework.boot:spring-boot-starter-amqp")
  implementation("org.springframework.boot:spring-boot-starter-cache")
  implementation("org.springframework.boot:spring-boot-starter-aop")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-websocket")
  implementation("org.springframework.boot:spring-boot-starter-data-redis") {exclude(group = "io.netty")}
//  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")

  developmentOnly("org.springframework.boot:spring-boot-devtools")

//  testImplementation("org.springframework.security:spring-security-test")
//  implementation("org.redisson:redisson:$redisson") {exclude(group = "io.netty")}
}
