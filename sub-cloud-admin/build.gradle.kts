import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

val activeProfiles: String by System.getProperties()
val serverAddr: String by System.getProperties()

application {
  mainClass.set("org.github.AdminKt")
  applicationDefaultJvmArgs = listOf(
    "-ea",

    "-Dspring.profiles.active=$activeProfiles",
    "-Dspring.cloud.nacos.discovery.server-addr=$serverAddr",
    "-Dserver.port=18999",

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
  archiveFileName.set("admin-boot.jar")
}

tasks.getByName<Task>("jar") {enabled = false}
tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

val netty: String by System.getProperties()

dependencies {
  implementation("de.codecentric:spring-boot-admin-starter-server") {exclude(group = "io.netty")}
  implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
}
