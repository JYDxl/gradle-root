import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.springframework.boot.gradle.tasks.run.BootRun

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

tasks.getByName<Task>("bootStartScripts") { enabled = false }
tasks.getByName<BootRun>("bootRun") { enabled = false }
tasks.getByName<Tar>("bootDistTar") { enabled = false }
tasks.getByName<Zip>("bootDistZip") { enabled = false }

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
  api("io.vertx:vertx-web") { exclude(group = "io.netty") }
  api("io.vertx:vertx-web-client") { exclude(group = "io.netty") }
  api("io.vertx:vertx-lang-kotlin") { exclude(group = "io.netty") }
  api("io.vertx:vertx-lang-kotlin-coroutines") { exclude(group = "io.netty") }

  implementation(project(":sub-core"))
  implementation("com.google.inject:guice:$guice")
  implementation("com.google.inject.extensions:guice-multibindings:$guice")

  testImplementation("io.vertx:vertx-junit5") { exclude(group = "io.netty");exclude(group = "org.junit.jupiter") }

  compileOnly("io.vertx:vertx-codegen") { exclude(group = "io.netty") }
  testCompileOnly("io.vertx:vertx-codegen") { exclude(group = "io.netty") }
}
