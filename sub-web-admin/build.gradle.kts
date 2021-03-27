import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
  enabled = true
  archiveFileName.set("admin.jar")
  mainClass.set("org.github.web.AdminKt")
}

val caffeine: String by System.getProperties()


dependencies {
  implementation("com.github.ben-manes.caffeine:caffeine:$caffeine")
  implementation("de.codecentric:spring-boot-admin-starter-server") { exclude(group = "io.netty") }
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-security")
}
