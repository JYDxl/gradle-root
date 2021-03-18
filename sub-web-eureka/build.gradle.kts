import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
  enabled = true
  archiveFileName.set("eureka.jar")
  mainClass.set("org.github.web.EurekaKt")
}

val caffeine: String by System.getProperties()

dependencies {
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server")
  implementation("com.github.ben-manes.caffeine:caffeine:$caffeine")
}
