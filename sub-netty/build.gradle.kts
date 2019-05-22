val protobuf: String by System.getProperties()
val netty: String by System.getProperties()

dependencies {
  api("com.google.protobuf:protobuf-java-util:$protobuf")

  api("io.netty:netty-all:$netty")
  api(project(":sub-model"))
  api(project(":sub-core"))

  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
