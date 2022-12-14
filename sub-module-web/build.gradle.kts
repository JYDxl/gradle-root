import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
  application
}

val activeProfiles: String by System.getProperties()
val serverAddr: String by System.getProperties()

application {
  mainClass.set("org.github.WebKt")
  applicationDefaultJvmArgs = listOf(
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:15002",

    "-ea",

    "-Dspring.profiles.active=$activeProfiles",
    "-Dspring.cloud.nacos.discovery.server-addr=$serverAddr",
    "-Dserver.port=19002",

    "-Dio.netty.tryReflectionSetAccessible=true",
    "-Dio.netty.leakDetection.level=advanced",
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

tasks.withType<BootJar> {
  archiveFileName.set("web-boot.jar")
}

tasks.withType<Test> {
  enabled = false
}

tasks.getByName<Task>("jar") {enabled = false}
tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("bootDistTar") {enabled = false}
tasks.getByName<Task>("bootDistZip") {enabled = false}

val mysql: String by System.getProperties()

dependencies {
  implementation(project(":sub-system-common"))
  implementation(project(":sub-system-sso"))
  implementation(project(":sub-module-center-service"))

  implementation("org.springframework.boot:spring-boot-starter-amqp")
  implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
  implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch") {exclude(group = "io.netty");exclude(group = "net.sf.jopt-simple");exclude(group = "joda-time")}
  implementation("org.springframework.kafka:spring-kafka") {exclude(group = "io.netty")}
  implementation("mysql:mysql-connector-java:$mysql")

  implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
  implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin")

  // implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-sentinel") {exclude(group = "io.netty")}
  // implementation("com.alibaba.csp:sentinel-datasource-nacos")
  // implementation("com.alibaba.cloud:spring-cloud-starter-alibaba-seata") {exclude(group = "com.alibaba", module = "druid")}
  // implementation("io.seata:seata-spring-boot-starter:$seata") {exclude(group = "com.alibaba", module = "druid")}
  // implementation("com.alibaba.cloud:spring-cloud-starter-dubbo") {exclude(group = "io.netty")}

  // testImplementation("org.springframework.kafka:spring-kafka-test") {exclude(group = "io.netty");exclude(group = "net.sf.jopt-simple")}
  // implementation("org.redisson:redisson:$redisson") {exclude(group = "io.netty")}
}
