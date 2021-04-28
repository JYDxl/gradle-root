import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val protobuf: String by System.getProperties()
val tcnative: String by System.getProperties()
val netty: String by System.getProperties()

plugins {
  application
  id("com.github.johnrengelman.shadow")
}

application {
  mainClass.set("org.github.ChatServerKt")
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true"
  )
}

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("jar") {enabled = false}

tasks.withType<ShadowJar> {
  archiveFileName.set("netty-boot.jar")
}

tasks.withType<Test> {
  jvmArgs = listOf(
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=paranoid",
    "-Djava.net.preferIPv4Stack=true"
  )
}

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")
  api("io.netty:netty-tcnative-boringssl-static:$tcnative")
  api("io.netty:netty-all:$netty")
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
