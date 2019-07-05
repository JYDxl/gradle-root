tasks.withType<Test> {
  jvmArgs = listOf("-ea", "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory")
}

val vertx: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("io.netty:netty-all:$netty")
  api("io.vertx:vertx-lang-kotlin:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-web:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-web-client:$vertx") { exclude(group = "io.netty") }

  implementation(project(":sub-netty"))
  implementation(project(":sub-model"))
  implementation(project(":sub-core"))

  testImplementation("io.vertx:vertx-unit:$vertx") { exclude(group = "io.netty") }

  compileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
  testCompileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
}
