import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.JavaVersion.VERSION_11
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinxCoroutines: String by System.getProperties()
val commonsLang3: String by System.getProperties()
val springCloud: String by System.getProperties()
val springAdmin: String by System.getProperties()
val springBoot: String by System.getProperties()
val caffeine: String by System.getProperties()
val fastjson: String by System.getProperties()
val protobuf: String by System.getProperties()
val j2cache: String by System.getProperties()
val jackson: String by System.getProperties()
val alibaba: String by System.getProperties()
val logback: String by System.getProperties()
val lombok: String by System.getProperties()
val groovy: String by System.getProperties()
val hutool: String by System.getProperties()
val guava: String by System.getProperties()
val guice: String by System.getProperties()
val vertx: String by System.getProperties()
val netty: String by System.getProperties()

plugins {
  val dependencyManagement: String by System.getProperties()
  val springBoot: String by System.getProperties()
  val benmanes: String by System.getProperties()
  val kotlin: String by System.getProperties()
  val shadow: String by System.getProperties()

  java

  id("com.github.johnrengelman.shadow") version shadow apply false
  id("org.springframework.boot") version springBoot apply false
  id("io.spring.dependency-management") version dependencyManagement apply false
  id("org.jetbrains.kotlin.jvm") version kotlin apply false
  id("org.jetbrains.kotlin.plugin.spring") version kotlin apply false
  id("com.github.ben-manes.versions") version benmanes apply false
}

allprojects {
  tasks.register("cleanAll", Delete::class) {
    delete = setOf("build", "out", "logs")
  }
}

subprojects {
  group = "org.github"
  version = "0.0.1"

  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "com.github.ben-manes.versions")
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")

  java {
    sourceCompatibility = VERSION_11
    targetCompatibility = VERSION_11
  }

  configure<DependencyManagementExtension> {
    imports {
      mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloud")
      mavenBom("org.springframework.boot:spring-boot-starter-parent:$springBoot")
      mavenBom("org.jetbrains.kotlinx:kotlinx-coroutines-bom:$kotlinxCoroutines")
      mavenBom("com.alibaba.cloud:spring-cloud-alibaba-dependencies:$alibaba")
      mavenBom("de.codecentric:spring-boot-admin-dependencies:$springAdmin")
      mavenBom("com.fasterxml.jackson:jackson-bom:$jackson")
      mavenBom("io.vertx:vertx-dependencies:$vertx")
      mavenBom("io.netty:netty-bom:$netty")
    }
  }

  repositories {
    maven {url = uri("https://maven.aliyun.com/repository/public")}
    maven {url = uri("https://maven.aliyun.com/repository/google")}
    maven {url = uri("https://maven.aliyun.com/repository/spring")}
    mavenLocal()
    mavenCentral()
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.verbose = true
    kotlinOptions.javaParameters = true
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
  }

  tasks.withType<JavaCompile> {
    options.compilerArgs.addAll(listOf("-Xlint:unchecked", "-parameters"))
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
    implementation("ch.qos.logback:logback-classic:$logback")
    implementation("ch.qos.logback:logback-core:$logback")
    implementation("org.slf4j:jul-to-slf4j")

    implementation("org.apache.commons:commons-lang3:$commonsLang3")
    implementation("org.codehaus.groovy:groovy:$groovy")
    implementation("com.google.inject:guice:$guice")
    implementation("com.google.guava:guava:$guava")
    implementation("cn.hutool:hutool-all:$hutool")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$kotlinxCoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:$kotlinxCoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:$kotlinxCoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxCoroutines")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines")

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
    implementation("com.google.protobuf:protobuf-java:$protobuf")

    implementation("commons-io:commons-io:2.11.0")
    implementation("org.ow2.asm:asm:9.2")
    implementation("org.checkerframework:checker-qual:3.21.0")
    implementation("org.objenesis:objenesis:3.2")
    implementation("org.javassist:javassist:3.28.0-GA")
    implementation("net.sf.jopt-simple:jopt-simple:5.0.4")
    // implementation("com.github.ifeilong:feilong:3.0.10")
    implementation("org.t-io:tio-core:3.7.6.v20211212-RELEASE")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    compileOnly("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")

    annotationProcessor("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
  }
}
