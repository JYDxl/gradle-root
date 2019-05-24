val mybatisplus: String by System.getProperties()
val mariadb: String by System.getProperties()

dependencies {
  api(project(":sub-core"))

  compileOnly("com.fasterxml.jackson.core:jackson-databind")
  compileOnly("org.springframework.boot:spring-boot")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisplus")

  testImplementation("com.baomidou:mybatis-plus-generator:$mybatisplus")
  testImplementation("org.mariadb.jdbc:mariadb-java-client:$mariadb")

  testImplementation("org.freemarker:freemarker")
}
