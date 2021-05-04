import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

application {
  mainClass.set("org.github.GatewayKt")
  applicationDefaultJvmArgs = listOf(
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true",
    "--illegal-access=deny"
  )
}

tasks.withType<BootJar> {
  archiveFileName.set("gateway-boot.jar")
}

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

dependencies {
  implementation(project(":sub-system"))
  implementation(project(":sub-core"))
  implementation(project(":sub-api"))

  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
  implementation("org.springframework.cloud:spring-cloud-starter-gateway") {exclude(group = "io.netty")}
  implementation("org.springframework.boot:spring-boot-starter-actuator")
}
