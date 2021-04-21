val commonscodec: String by System.getProperties()
val mybatisplus: String by System.getProperties()
val javassist: String by System.getProperties()
val caffeine: String by System.getProperties()
val protobuf: String by System.getProperties()
val byteman: String by System.getProperties()
val j2cache: String by System.getProperties()
val netty: String by System.getProperties()
val p6spy: String by System.getProperties()
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
    "-Djava.net.preferIPv4Stack=true",
    "--add-exports=java.base/jdk.internal.misc=ALL-UNNAMED",
    "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED"
  )
}

dependencies {
  compileOnly("org.springframework.boot:spring-boot-starter-amqp")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-data-redis") {exclude(group = "io.netty")}
  compileOnly("javax.servlet:javax.servlet-api")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisplus")
  compileOnly("com.google.protobuf:protobuf-java-util:$protobuf")
  compileOnly("com.baomidou:mybatis-plus-core:$mybatisplus")
  compileOnly("io.netty:netty-all:$netty")
  compileOnly("p6spy:p6spy:$p6spy")
  compileOnly("net.oschina.j2cache:j2cache-core:$j2cache")

  testImplementation("com.github.ben-manes.caffeine:caffeine:$caffeine")
  testImplementation("commons-codec:commons-codec:$commonscodec")
  testImplementation("org.jboss.byteman:byteman:$byteman")
  testImplementation("org.javassist:javassist:$javassist")
  testImplementation("net.java.dev.jna:jna:$jna")
  testImplementation("io.netty:netty-all:$netty")
}
