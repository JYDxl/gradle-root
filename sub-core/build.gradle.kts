val commonscodec: String by System.getProperties()
val mybatisplus: String by System.getProperties()
val javassist: String by System.getProperties()
val byteman: String by System.getProperties()
val netty: String by System.getProperties()
val mysql: String by System.getProperties()
val jna: String by System.getProperties()

plugins {
  `maven-publish`
}

java {
  withSourcesJar()
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      from(components["java"])
    }
  }
}

tasks.withType<Test> {
  jvmArgs = listOf(
    "-ea",
    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=paranoid",
    "-Djava.net.preferIPv4Stack=true"
  )
}

dependencies {
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-data-redis") {exclude(group = "io.netty")}

  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisplus")

  compileOnly("io.netty:netty-all:$netty")

  testImplementation("commons-codec:commons-codec:$commonscodec")
  testImplementation("org.jboss.byteman:byteman:$byteman")
  testImplementation("org.javassist:javassist:$javassist")
  testImplementation("net.java.dev.jna:jna:$jna")
  testImplementation("io.netty:netty-all:$netty")

  testImplementation("com.baomidou:mybatis-plus-generator:3.4.1")
  testImplementation("mysql:mysql-connector-java:$mysql")
  testImplementation("org.freemarker:freemarker")
}
