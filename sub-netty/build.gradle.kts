tasks.withType<Test> {
  jvmArgs = listOf("-ea", "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory")
}

val protobuf: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")
  api("io.netty:netty-all:$netty")

  implementation(project(":sub-model"))
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
