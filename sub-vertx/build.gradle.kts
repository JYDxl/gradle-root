plugins {
  application
}

configure<ApplicationPluginConvention> {
  mainClassName = "org.github.StarterKt"
}

val vertx: String by System.getProperties()

dependencies {
  api("io.vertx:vertx-lang-kotlin:$vertx") { exclude(group = "io.netty") }
  api("io.vertx:vertx-web:$vertx") { exclude(group = "io.netty") }

  api(project(":sub-netty"))

  testImplementation("io.vertx:vertx-unit:$vertx") { exclude(group = "io.netty") }

  compileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
  testCompileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
}
