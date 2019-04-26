import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  val springbootVersion = "2.1.4.RELEASE"
  val kotlinVersion = "1.3.31"
  val benmanesVersion = "0.21.0"

  java

  kotlin("plugin.spring") version kotlinVersion apply false
  kotlin("jvm") version kotlinVersion apply false
  id("com.github.ben-manes.versions") version benmanesVersion apply false
  id("org.springframework.boot") version springbootVersion apply false
}

allprojects {
  group = "org.github"
  version = "0.0.1-SNAPSHOT"
}

subprojects {
  val mybatisPlusVersion = "3.1.1"
  val vertxVersion = "3.7.0"

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
    implementation("io.vertx:vertx-web:$vertxVersion") { exclude(group = "io.netty") }
    implementation("org.mariadb.jdbc:mariadb-java-client:2.4.1")
    implementation("com.google.protobuf:protobuf-java-util:3.7.1")
    implementation("com.baomidou:mybatis-plus-boot-starter:$mybatisPlusVersion")
    implementation("org.apache.commons:commons-lang3:3.9")
    implementation("commons-codec:commons-codec:1.12")
    implementation("com.squareup.okhttp3:okhttp:3.14.1")
    implementation("com.google.guava:guava:27.1-jre")
    implementation("com.google.inject:guice:4.2.2")
    implementation("com.github.ben-manes.caffeine:caffeine:2.7.0")
    implementation("io.netty:netty-all:4.1.35.Final")
    implementation("io.reactivex.rxjava2:rxjava:2.2.8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.2.1")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("net.java.dev.jna:jna:5.3.0")
    implementation("org.javassist:javassist:3.25.0-GA")
    implementation("org.jctools:jctools-core:2.1.2")
    implementation("org.jboss.byteman:byteman:4.0.6")
    implementation("p6spy:p6spy:3.8.2")
    implementation("org.apache.commons:commons-pool2:2.6.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test") { exclude(module = "android-json") }
    testImplementation("io.vertx:vertx-unit:$vertxVersion") { exclude(group = "io.netty") }
    testImplementation("com.baomidou:mybatis-plus-generator:$mybatisPlusVersion")

    compileOnly("io.vertx:vertx-codegen:$vertxVersion") { exclude(group = "io.netty") }
    testCompileOnly("io.vertx:vertx-codegen:$vertxVersion") { exclude(group = "io.netty") }

    compileOnly("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")

    annotationProcessor("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
  }
}
