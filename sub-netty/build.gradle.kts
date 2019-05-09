val protobuf: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")
  api("io.netty:netty-all:$netty")

  compileOnly(project(":sub-model"))
  compileOnly(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
