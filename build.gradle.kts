import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.JavaVersion.VERSION_11
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinxcoroutines: String by System.getProperties()
val commonslang3: String by System.getProperties()
val springcloud: String by System.getProperties()
val springadmin: String by System.getProperties()
val springboot: String by System.getProperties()
val caffeine: String by System.getProperties()
val fastjson: String by System.getProperties()
val j2cache: String by System.getProperties()
val jackson: String by System.getProperties()
val alibaba: String by System.getProperties()
val lombok: String by System.getProperties()
val groovy: String by System.getProperties()
val hutool: String by System.getProperties()
val guava: String by System.getProperties()
val guice: String by System.getProperties()
val vertx: String by System.getProperties()

plugins {
  val dependencymanagement: String by System.getProperties()
  val springboot: String by System.getProperties()
  val benmanes: String by System.getProperties()
  val kotlin: String by System.getProperties()
  val shadow: String by System.getProperties()

  java

  id("com.github.johnrengelman.shadow") version shadow apply false
  id("org.springframework.boot") version springboot apply false
  id("io.spring.dependency-management") version dependencymanagement apply false
  id("org.jetbrains.kotlin.jvm") version kotlin apply false
  id("org.jetbrains.kotlin.plugin.spring") version kotlin apply false
  id("com.github.ben-manes.versions") version benmanes apply false
}

subprojects {
  group = "org.github"
  version = "0.0.1"

  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "com.github.ben-manes.versions")
  apply(plugin = "kotlin")
  apply(plugin = "jacoco")
  apply(plugin = "kotlin-spring")

  java {
    sourceCompatibility = VERSION_11
    targetCompatibility = VERSION_11
  }

  configure<DependencyManagementExtension> {
    imports {
      mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springcloud")
      mavenBom("org.springframework.boot:spring-boot-starter-parent:$springboot")
      mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:$alibaba")
      mavenBom("de.codecentric:spring-boot-admin-dependencies:$springadmin")
      mavenBom("com.fasterxml.jackson:jackson-bom:$jackson")
      mavenBom("io.vertx:vertx-dependencies:$vertx")
    }
  }

  repositories {
    maven {url = uri("http://maven.aliyun.com/repository/public");isAllowInsecureProtocol = true}
    maven {url = uri("http://maven.aliyun.com/repository/spring");isAllowInsecureProtocol = true}
    maven {url = uri("http://maven.aliyun.com/repository/google");isAllowInsecureProtocol = true}
    mavenCentral()
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.verbose = true
    kotlinOptions.javaParameters = true
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
  }

  tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:unchecked")
  }

  tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
      events("PASSED", "FAILED", "SKIPPED")
    }
  }

  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("ch.qos.logback:logback-classic")
    implementation("org.slf4j:jul-to-slf4j")

    implementation("org.apache.commons:commons-lang3:$commonslang3")
    implementation("org.codehaus.groovy:groovy:$groovy")
    implementation("com.google.inject:guice:$guice")
    implementation("com.google.guava:guava:$guava")
    implementation("cn.hutool:hutool-all:$hutool")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:$kotlinxcoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxcoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxcoroutines")

    implementation("com.fasterxml.jackson.core:jackson-annotations:$jackson")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson")
    implementation("com.fasterxml.jackson.core:jackson-core:$jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-jaxb-annotations:$jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:$jackson")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-guava:$jackson")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jackson")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jackson")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jackson")

    implementation("net.oschina.j2cache:j2cache-core:$j2cache") {
      exclude(group = "com.alibaba")
      exclude(group = "redis.clients")
      exclude(group = "org.slf4j")
    }
    implementation("com.alibaba:fastjson:$fastjson")
    implementation("com.github.ben-manes.caffeine:caffeine:$caffeine")

    implementation("org.checkerframework:checker-qual:3.12.0")
    implementation("org.objenesis:objenesis:3.2")
    implementation("org.javassist:javassist:3.27.0-GA")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    compileOnly("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")

    annotationProcessor("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
  }
}
