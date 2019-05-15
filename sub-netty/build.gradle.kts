val protobuf: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")

  implementation("io.netty:netty-all:$netty")
  implementation(project(":sub-model"))
  implementation(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
