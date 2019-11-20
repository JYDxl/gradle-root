import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val kotlinxcoroutines: String by System.getProperties()
val vertx: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("io.netty:netty-all:$netty")
  api("io.vertx:vertx-web:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-web-client:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-lang-kotlin:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-lang-kotlin-coroutines:$vertx") { exclude(group = "io.netty") }
  api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxcoroutines")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-guava:$kotlinxcoroutines")

  implementation(project(":sub-netty"))
  implementation(project(":sub-model"))
  implementation(project(":sub-core"))

  testImplementation("io.vertx:vertx-junit5:$vertx") { exclude(group = "io.netty");exclude(group = "org.junit.jupiter") }

  compileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
  testCompileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
}

tasks.withType<ShadowJar> {
  archiveFileName.set("vertx-boot.jar")
  manifest {
    attributes(mapOf("Main-Class" to "org.github.ApplicationKt"))
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events("PASSED", "FAILED", "SKIPPED")
  }
  jvmArgs = listOf(
    "-ea",
    "-Djava.library.path=native",
    "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "--illegal-access=deny",
    "--add-opens=java.base/java.nio=ALL-UNNAMED",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED"
  )
}
