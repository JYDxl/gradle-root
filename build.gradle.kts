import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

val kotlinxCoroutines: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val commonsLang3: String by System.getProperties()
val commonsCodec: String by System.getProperties()
val commonsPool2: String by System.getProperties()
val protobuf: String by System.getProperties()
val caffeine: String by System.getProperties()
val retrofit: String by System.getProperties()
val mariadb: String by System.getProperties()
val okhttp3: String by System.getProperties()
val rxjava2: String by System.getProperties()
val jctools: String by System.getProperties()
val byteman: String by System.getProperties()
val lombok: String by System.getProperties()
val vertx: String by System.getProperties()
val guava: String by System.getProperties()
val guice: String by System.getProperties()
val netty: String by System.getProperties()
val p6spy: String by System.getProperties()
val jedis: String by System.getProperties()
val jna: String by System.getProperties()
val javassist: String by System.getProperties()

plugins {
  val springBoot: String by System.getProperties()
  val kotlin: String by System.getProperties()
  val benmanes: String by System.getProperties()

  java

  kotlin("plugin.spring") version kotlin apply false
  kotlin("jvm") version kotlin apply false
  id("com.github.ben-manes.versions") version benmanes apply false
  id("org.springframework.boot") version springBoot apply false
}

allprojects {
  group = "org.github"
  version = "0.0.1-SNAPSHOT"
}

subprojects {
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "com.github.ben-manes.versions")

  configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_1_8
    targetCompatibility = VERSION_1_8
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
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.vertx:vertx-web:$vertx") { exclude(group = "io.netty") }
    implementation("org.mariadb.jdbc:mariadb-java-client:$mariadb")
    implementation("com.google.protobuf:protobuf-java-util:$protobuf")
    implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")
    implementation("org.apache.commons:commons-lang3:$commonsLang3")
    implementation("commons-codec:commons-codec:$commonsCodec")
    implementation("com.squareup.okhttp3:okhttp:$okhttp3")
    implementation("com.google.guava:guava:$guava")
    implementation("com.google.inject:guice:$guice")
    implementation("com.github.ben-manes.caffeine:caffeine:$caffeine")
    implementation("io.netty:netty-all:$netty")
    implementation("io.reactivex.rxjava2:rxjava:$rxjava2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxCoroutines")
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("net.java.dev.jna:jna:$jna")
    implementation("org.javassist:javassist:$javassist")
    implementation("org.jctools:jctools-core:$jctools")
    implementation("org.jboss.byteman:byteman:$byteman")
    implementation("p6spy:p6spy:$p6spy")
    implementation("org.apache.commons:commons-pool2:$commonsPool2")
    implementation("redis.clients:jedis:$jedis")

    testImplementation("org.springframework.boot:spring-boot-starter-test") { exclude(module = "android-json") }
    testImplementation("io.vertx:vertx-unit:$vertx") { exclude(group = "io.netty") }

    compileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }
    testCompileOnly("io.vertx:vertx-codegen:$vertx") { exclude(group = "io.netty") }

    compileOnly("org.projectlombok:lombok:$lombok")
    testCompileOnly("org.projectlombok:lombok:$lombok")

    annotationProcessor("org.projectlombok:lombok:$lombok")
    testAnnotationProcessor("org.projectlombok:lombok:$lombok")
  }
}
