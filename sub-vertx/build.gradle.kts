import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val netty: String by System.getProperties()
val guice: String by System.getProperties()

plugins {
  application
  id("com.github.johnrengelman.shadow")
}

application {
  @Suppress("DEPRECATION")
  mainClassName = "org.github.VertxAppKt"
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",
    "-ea",
    "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED"
  )
}

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("jar") {enabled = false}

tasks.withType<ShadowJar> {
  archiveFileName.set("vertx-boot.jar")
}

tasks.withType<Test> {
  jvmArgs = listOf(
    "-ea",
    "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=paranoid",
    "-Djava.net.preferIPv4Stack=true",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED"
  )
}

dependencies {
  api("io.netty:netty-all:$netty")
  api("io.vertx:vertx-web") {exclude(group = "io.netty")}
  api("io.vertx:vertx-web-client") {exclude(group = "io.netty")}
  api("io.vertx:vertx-lang-kotlin") {exclude(group = "io.netty")}
  api("io.vertx:vertx-lang-kotlin-coroutines") {exclude(group = "io.netty")}

  implementation(project(":sub-core"))
  implementation("com.google.inject:guice:$guice")

  testImplementation("io.vertx:vertx-junit5") {exclude(group = "io.netty")}

  compileOnly("io.vertx:vertx-codegen") {exclude(group = "io.netty")}
  testCompileOnly("io.vertx:vertx-codegen") {exclude(group = "io.netty")}
}
