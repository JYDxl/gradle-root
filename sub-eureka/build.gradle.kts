import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
}

tasks.withType<BootJar> {
  archiveFileName.set("eureka-boot.jar")
  mainClass.set("org.github.web.EurekaKt")
}

dependencies {
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
}
