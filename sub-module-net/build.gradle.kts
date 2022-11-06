import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

val activeProfiles: String by System.getProperties()
val serverAddr: String by System.getProperties()
val protobuf: String by System.getProperties()
val tcnative: String by System.getProperties()

application {
  mainClass.set("org.github.NetKt")
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",

    "-ea",

    "-Dspring.profiles.active=$activeProfiles",

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
  archiveFileName.set("net-boot.jar")
}

tasks.getByName<Task>("jar") {enabled = false}
tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

val commonsPool2: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val retrofit: String by System.getProperties()
val redisson: String by System.getProperties()
val okhttp3: String by System.getProperties()
val mysql: String by System.getProperties()
val p6spy: String by System.getProperties()
val netty: String by System.getProperties()
val jedis: String by System.getProperties()
val seata: String by System.getProperties()
val jwt: String by System.getProperties()

dependencies {
  implementation(project(":sub-system-core"))

  implementation("com.google.protobuf:protobuf-java-util:$protobuf")
  implementation("io.netty:netty-tcnative-boringssl-static:$tcnative")
  implementation("io.netty:netty-tcnative-classes:$tcnative")
  implementation("io.netty:netty-all:$netty")

  implementation("org.springframework.boot:spring-boot-starter")

  developmentOnly("org.springframework.boot:spring-boot-devtools")
}
