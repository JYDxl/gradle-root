@file:Suppress("DEPRECATION")

import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<Jar> { enabled = false }

tasks.withType<BootJar> {
  enabled = true
  version = ""
}

tasks.withType<Test> {
  enabled = false
  jvmArgs = listOf("-Djava.library.path=/usr/local/opt/tomcat-native/lib")
}

dependencies {
  implementation(project(":sub-config"))
  implementation(project(":sub-core"))
  implementation(project(":sub-model"))
  implementation(project(":sub-vertx"))
  implementation(project(":sub-netty"))

  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-amqp")
  implementation("org.springframework.boot:spring-boot-starter-cache")
  implementation("org.springframework.boot:spring-boot-starter-aop")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-websocket")
  implementation("org.springframework.boot:spring-boot-starter-data-redis") { exclude(group = "io.lettuce") }
  implementation("org.springframework.session:spring-session-data-redis")

  runtimeOnly("org.springframework.boot:spring-boot-devtools")

  testImplementation("org.springframework.security:spring-security-test")
}
