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
    "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED",
    "--add-opens=java.base/java.util=ALL-UNNAMED",
    "--add-opens=java.base/java.lang.reflect=ALL-UNNAMED",
    "--add-opens=java.base/java.lang.invoke=ALL-UNNAMED",
    "--add-opens=java.base/java.lang=ALL-UNNAMED",
    "--add-opens=java.base/java.math=ALL-UNNAMED",
    "--add-opens=java.base/java.text=ALL-UNNAMED",
    "--add-opens=java.base/java.time=ALL-UNNAMED",
    "--add-opens=java.base/java.nio=ALL-UNNAMED",
    "--add-opens=java.base/java.net=ALL-UNNAMED"
  )
}

val commonsCodec: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val postgresql: String by System.getProperties()
val asyncTool: String by System.getProperties()
val protobuf: String by System.getProperties()
val saToken: String by System.getProperties()
val byteman: String by System.getProperties()
val aviator: String by System.getProperties()
val mysql: String by System.getProperties()
val p6spy: String by System.getProperties()
val minio: String by System.getProperties()
val guice: String by System.getProperties()

dependencies {
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-aop")
  compileOnly("org.springframework.boot:spring-boot-starter-data-redis") {exclude(group = "io.netty")}
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("org.springframework.cloud:spring-cloud-context")

  compileOnly("com.google.inject:guice:$guice")
  compileOnly("com.googlecode.aviator:aviator:$aviator")
  compileOnly("com.gitee.jd-platform-opensource:asyncTool:$asyncTool")
  compileOnly("commons-codec:commons-codec:$commonsCodec")
  compileOnly("org.jboss.byteman:byteman:$byteman")

  compileOnly("org.t-io:tio-core:3.8.3.v20220902-RELEASE") {exclude(group = "com.alibaba")}

  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")
  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
  compileOnly("io.minio:minio:$minio")
  compileOnly("p6spy:p6spy:$p6spy")

  testImplementation("com.baomidou:mybatis-plus-generator:3.5.3")
  testImplementation("com.baomidou:mybatis-plus-extension:$mybatisPlus")
  testImplementation("mysql:mysql-connector-java:$mysql")
  testImplementation("org.postgresql:postgresql:$postgresql")
  testImplementation("org.freemarker:freemarker")
}
