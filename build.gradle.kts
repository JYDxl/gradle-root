import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.JavaVersion.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

val kotlinxcoroutines: String by System.getProperties()
val commonslang3: String by System.getProperties()
val springcloud: String by System.getProperties()
val reactor: String by System.getProperties()
val jackson: String by System.getProperties()
val lombok: String by System.getProperties()
val groovy: String by System.getProperties()
val guava: String by System.getProperties()
val junit: String by System.getProperties()

plugins {
  val dependencymanagement: String by System.getProperties()
  val springboot: String by System.getProperties()
  val benmanes: String by System.getProperties()
  val kotlin: String by System.getProperties()
  val shadow: String by System.getProperties()

  java
  `maven-publish`

  id("com.github.johnrengelman.shadow") version shadow apply false
  id("org.springframework.boot") version springboot apply false
  id("io.spring.dependency-management") version dependencymanagement apply false
  kotlin("jvm") version kotlin apply false
  kotlin("plugin.spring") version kotlin apply false
  id("com.github.ben-manes.versions") version benmanes apply false
}

subprojects {
  group = "org.github"
  version = "0.0.1"

  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "com.github.johnrengelman.shadow")
  apply(plugin = "com.github.ben-manes.versions")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "maven-publish")

  configure<DependencyManagementExtension> {
    imports {
      mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springcloud")
      mavenBom("io.projectreactor:reactor-bom:$reactor")
    }
  }

  configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_11
    targetCompatibility = VERSION_11
  }

  repositories {
    maven { url = uri("http://maven.aliyun.com/repository/public");isAllowInsecureProtocol = true }
    maven { url = uri("http://maven.aliyun.com/repository/spring");isAllowInsecureProtocol = true }
    maven { url = uri("http://maven.aliyun.com/repository/google");isAllowInsecureProtocol = true }
    mavenCentral()
  }

  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("ch.qos.logback:logback-classic")
    implementation("org.slf4j:jul-to-slf4j")

    implementation("org.apache.commons:commons-lang3:$commonslang3")
    implementation("com.google.guava:guava:$guava")
    implementation("org.codehaus.groovy:groovy:$groovy")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:$kotlinxcoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxcoroutines")

    implementation("com.fasterxml.jackson.core:jackson-annotations:$jackson")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson")
    implementation("com.fasterxml.jackson.core:jackson-core:$jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:$jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr353:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-guava:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jackson")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit")

    compileOnly("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")

    annotationProcessor("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
  }

  tasks.getByName<Jar>("jar") { enabled = true }
  tasks.getByName<BootJar>("bootJar") { enabled = false }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.verbose = true
    kotlinOptions.javaParameters = true
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
  }

  tasks.register<Jar>("sourcesJar") {
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
  }

  tasks.register<Jar>("javadocJar") {
    from(tasks.javadoc)
    archiveClassifier.set("javadoc")
  }

  publishing {
    publications {
      create<MavenPublication>("mavenJava") {
        from(components["java"])

        artifact(tasks["sourcesJar"])
        artifact(tasks["javadocJar"])

        versionMapping {
          usage("java-api") {
            fromResolutionOf("runtimeClasspath")
          }

          usage("java-runtime") {
            fromResolutionResult()
          }
        }
      }
    }

    repositories {
      maven {
        url = uri("${System.getProperty("user.home")}/.m2/repository")
      }
    }
  }
}
