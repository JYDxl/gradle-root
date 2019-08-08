import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.JavaVersion.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import java.lang.System.*

val commonslang3: String by System.getProperties()
val commonscodec: String by System.getProperties()
val springcloud: String by System.getProperties()
val caffeine: String by System.getProperties()
val jctools: String by System.getProperties()
val lombok: String by System.getProperties()
val groovy: String by System.getProperties()
val guava: String by System.getProperties()

plugins {
  val springboot: String by System.getProperties()
  val benmanes: String by System.getProperties()
  val kotlin: String by System.getProperties()

  java
  `maven-publish`

  kotlin("plugin.spring") version kotlin apply false
  kotlin("jvm") version kotlin apply false
  id("com.github.ben-manes.versions") version benmanes apply false
  id("org.springframework.boot") version springboot apply false
}

subprojects {
  group = "org.github"
  version = "0.0.1"

  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "com.github.ben-manes.versions")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "maven-publish")

  configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_1_8
    targetCompatibility = VERSION_1_8
  }

  configure<DependencyManagementExtension> {
    imports {
      mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springcloud")
    }
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
  }

  tasks.withType<Jar> { enabled = true }
  tasks.withType<BootJar> { enabled = false }

  repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    maven { url = uri("https://maven.aliyun.com/repository/spring") }
    maven { url = uri("https://maven.aliyun.com/repository/google") }
    mavenCentral()
  }

  dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("ch.qos.logback:logback-classic")

    compile("com.github.ben-manes.caffeine:caffeine:$caffeine")
    compile("org.apache.commons:commons-lang3:$commonslang3")
    compile("commons-codec:commons-codec:$commonscodec")
    compile("org.jctools:jctools-core:$jctools")
    compile("com.google.guava:guava:$guava")
    compile("org.codehaus.groovy:groovy:$groovy")
    compile("org.slf4j:jul-to-slf4j")

    testImplementation("junit:junit")

    compileOnly("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")

    annotationProcessor("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
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
        url = uri("${getProperty("user.home")}/.m2/repository")
      }
    }
  }
}
