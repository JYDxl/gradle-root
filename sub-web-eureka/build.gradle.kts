import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
}

tasks.withType<BootJar> {
  archiveFileName.set("eureka-boot.jar")
  mainClass.set("org.github.web.EurekaKt")
}

val caffeine: String by System.getProperties()

dependencies {
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
  implementation("com.github.ben-manes.caffeine:caffeine:$caffeine")
  implementation("de.codecentric:spring-boot-admin-starter-client")
  implementation("org.springframework.boot:spring-boot-starter-security")
}
