import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val protobuf: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")
  api("io.netty:netty-all:$netty")
  api("io.projectreactor.netty:reactor-netty") { exclude(group = "io.netty") }
  api("io.projectreactor.kotlin:reactor-kotlin-extensions")
  api(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}

tasks.getByName<Jar>("jar") {
  enabled = true
  excludes += "logback.groovy"
}

tasks.withType<ShadowJar> {
  minimize()
  archiveFileName.set("netty-boot.jar")
  manifest {
    attributes(mapOf("Main-Class" to "org.github.NettyAppKt"))
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events("PASSED", "FAILED", "SKIPPED")
  }
  jvmArgs = listOf(
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Djava.net.preferIPv4Stack=true",
    "-Djava.library.path=../native",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED",
    "--illegal-access=deny"
  )
}
