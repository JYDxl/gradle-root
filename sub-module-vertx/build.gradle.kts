import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
  application
  id("com.github.johnrengelman.shadow")
}

application {
  mainClass.set("org.github.VertxAppKt")
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:15005",

    "-ea",

    "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory",

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

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("jar") {enabled = false}
tasks.getByName<Task>("shadowDistTar") {enabled = false}
tasks.getByName<Task>("shadowDistZip") {enabled = false}

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

val kotlinxCoroutines: String by System.getProperties()

dependencies {
  implementation(project(":sub-system-core"))

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$kotlinxCoroutines")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:$kotlinxCoroutines")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:$kotlinxCoroutines")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxCoroutines")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines")

  implementation("io.vertx:vertx-web") {exclude(group = "io.netty")}
  implementation("io.vertx:vertx-web-client") {exclude(group = "io.netty")}
  implementation("io.vertx:vertx-lang-kotlin") {exclude(group = "io.netty")}
  implementation("io.vertx:vertx-lang-kotlin-coroutines") {exclude(group = "io.netty")}

  testImplementation("io.vertx:vertx-junit5") {exclude(group = "io.netty")}

  compileOnly("io.vertx:vertx-codegen") {exclude(group = "io.netty")}
  testCompileOnly("io.vertx:vertx-codegen") {exclude(group = "io.netty")}
}
