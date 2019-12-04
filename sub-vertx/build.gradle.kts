import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val vertx: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("io.netty:netty-all:$netty")
  api("io.vertx:vertx-web:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-web-client:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-lang-kotlin:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-lang-kotlin-coroutines:$vertx") { exclude(group = "io.netty") }

  implementation(project(":sub-core"))

  testImplementation("io.vertx:vertx-junit5:$vertx") { exclude(group = "io.netty");exclude(group = "org.junit.jupiter") }

  compileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
  testCompileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
}

tasks.getByName<Jar>("jar") {
  enabled = true
  excludes += "logback.groovy"
}

tasks.withType<ShadowJar> {
  minimize()
  archiveFileName.set("vertx-boot.jar")
  manifest {
    attributes(mapOf("Main-Class" to "org.github.VertxAppKt"))
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events("PASSED", "FAILED", "SKIPPED")
  }
  jvmArgs = listOf(
    "-ea",
    "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Djava.net.preferIPv4Stack=true",
    "-Djava.library.path=../native",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED",
    "--illegal-access=deny"
  )
}
