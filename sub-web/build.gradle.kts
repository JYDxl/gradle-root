@file:Suppress("DEPRECATION")

import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<Jar> { enabled = false }

tasks.withType<BootJar> {
  enabled = true
  archiveName = "web-boot.jar"
}

tasks.withType<Test> {
  enabled = false
  jvmArgs = listOf("-Djava.library.path=/usr/local/opt/tomcat-native/lib")
}

val commonsPool2: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val retrofit: String by System.getProperties()
val mariadb: String by System.getProperties()
val okhttp3: String by System.getProperties()
val p6spy: String by System.getProperties()
val jedis: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  implementation(project(":sub-config"))
  implementation(project(":sub-core"))
  implementation(project(":sub-model"))
  implementation(project(":sub-vertx"))
  implementation(project(":sub-netty"))

  implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")
  implementation("org.apache.commons:commons-pool2:$commonsPool2")
  implementation("org.mariadb.jdbc:mariadb-java-client:$mariadb")
  implementation("com.squareup.retrofit2:retrofit:$retrofit")
  implementation("com.squareup.okhttp3:okhttp:$okhttp3")
  implementation("redis.clients:jedis:$jedis")
  implementation("io.netty:netty-all:$netty")
  implementation("p6spy:p6spy:$p6spy")

  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-amqp")
  implementation("org.springframework.boot:spring-boot-starter-cache")
  implementation("org.springframework.boot:spring-boot-starter-aop")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-websocket")
  implementation("org.springframework.boot:spring-boot-starter-data-redis") { exclude(group = "io.lettuce") }
  implementation("org.springframework.session:spring-session-data-redis")

  runtimeOnly("org.springframework.boot:spring-boot-devtools")

  testImplementation("org.springframework.boot:spring-boot-starter-test") { exclude(module = "android-json") }
  testImplementation("org.springframework.security:spring-security-test")
}
