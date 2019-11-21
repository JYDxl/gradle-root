import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val protobuf: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")
  api("io.netty:netty-all:$netty")

  api(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}

tasks.getByName<Jar>("jar") {
  enabled = true
  excludes += "logback.groovy"
}

tasks.withType<ShadowJar> {
  archiveFileName.set("netty-boot.jar")
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
    "-Djava.library.path=../native",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "--illegal-access=deny",
    "--add-opens=java.base/java.nio=ALL-UNNAMED",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED"
  )
}
