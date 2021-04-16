import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
}

tasks.withType<BootJar> {
  archiveFileName.set("admin-boot.jar")
  mainClass.set("org.github.web.AdminKt")
}

val caffeine: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  implementation("com.github.ben-manes.caffeine:caffeine:$caffeine")
  implementation("de.codecentric:spring-boot-admin-starter-server") {exclude(group = "io.netty")}
//  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
  implementation("io.netty:netty-all:$netty")
  implementation("org.springframework.boot:spring-boot-starter-web")
}
