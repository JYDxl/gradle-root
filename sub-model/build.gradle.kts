val mybatisPlus: String by System.getProperties()
val mariadb: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-core"))

  compileOnly("com.fasterxml.jackson.core:jackson-databind")
  compileOnly("org.springframework.boot:spring-boot")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisPlus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")

  testImplementation("com.baomidou:mybatis-plus-generator:$mybatisPlus")
  testImplementation("org.mariadb.jdbc:mariadb-java-client:$mariadb")

  testImplementation("org.freemarker:freemarker")
}
