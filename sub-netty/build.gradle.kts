import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.springframework.boot.gradle.tasks.run.BootRun

val protobuf: String by System.getProperties()
val tcnative: String by System.getProperties()
val netty: String by System.getProperties()

plugins {
  application
  id("com.github.johnrengelman.shadow")
}

application {
  @Suppress("DEPRECATION")
  mainClassName = "org.github.ChatServerKt"
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
    "-Djava.net.preferIPv4Stack=true",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED"
  )
}

tasks.getByName<Task>("bootStartScripts") { enabled = false }
tasks.getByName<BootRun>("bootRun") { enabled = false }
tasks.getByName<Tar>("bootDistTar") { enabled = false }
tasks.getByName<Zip>("bootDistZip") { enabled = false }

tasks.withType<ShadowJar> {
  archiveFileName.set("netty-boot.jar")
}

tasks.withType<Test> {
  jvmArgs = listOf(
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=paranoid",
    "-Djava.net.preferIPv4Stack=true",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED"
  )
}

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")
  api("io.netty:netty-tcnative-boringssl-static:$tcnative")
  api("io.netty:netty-all:$netty")
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
