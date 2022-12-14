val commonsCodec: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val postgresql: String by System.getProperties()
val javassist: String by System.getProperties()
val saToken: String by System.getProperties()
val byteman: String by System.getProperties()
val netty: String by System.getProperties()
val mysql: String by System.getProperties()
val p6spy: String by System.getProperties()
val minio: String by System.getProperties()

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

dependencies {
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-aop")
  compileOnly("org.springframework.boot:spring-boot-starter-data-redis") {exclude(group = "io.netty")}
  compileOnly("org.springframework.boot:spring-boot-starter-validation")
  compileOnly("org.springframework.cloud:spring-cloud-context")

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
