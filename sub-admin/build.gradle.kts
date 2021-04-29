import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

application {
  mainClass.set("org.github.web.AdminKt")
  applicationDefaultJvmArgs = listOf(
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true",
    "--illegal-access=deny"
  )
}

tasks.withType<BootJar> {
  archiveFileName.set("admin-boot.jar")
}

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

val netty: String by System.getProperties()

dependencies {
  implementation("de.codecentric:spring-boot-admin-starter-server") {exclude(group = "io.netty")}
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
  implementation("io.netty:netty-all:$netty")
  implementation("org.springframework.boot:spring-boot-starter-web")
}
