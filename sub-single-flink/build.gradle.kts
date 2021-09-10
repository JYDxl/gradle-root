import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val flink: String by System.getProperties()

plugins {
  application
  id("com.github.johnrengelman.shadow")
}

application {
  mainClass.set("flink")
  applicationDefaultJvmArgs = listOf(
    "-ea"
  )
}

tasks.getByName<Task>("startScripts") {enabled = false}
tasks.getByName<Task>("distTar") {enabled = false}
tasks.getByName<Task>("distZip") {enabled = false}
tasks.getByName<Task>("jar") {enabled = false}
tasks.getByName<Task>("shadowDistTar") {enabled = false}
tasks.getByName<Task>("shadowDistZip") {enabled = false}

tasks.withType<ShadowJar> {
  archiveFileName.set("flink-boot.jar")
}

tasks.withType<Test> {
  jvmArgs = listOf(
    "-ea"
  )
}

dependencies {
  compileOnly("org.apache.flink:flink-java:$flink")
  compileOnly("org.apache.flink:flink-clients_2.12:$flink")
  compileOnly("org.apache.flink:flink-streaming-java_2.12:$flink")
  testImplementation("org.apache.flink:flink-runtime-web_2.12:$flink")
}
