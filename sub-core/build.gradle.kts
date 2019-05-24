val mybatisplus: String by System.getProperties()

dependencies {
  compileOnly("org.springframework.boot:spring-boot-starter-amqp")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-data-redis") { exclude(group = "io.lettuce") }
  compileOnly("javax.servlet:javax.servlet-api")

  compileOnly("com.baomidou:mybatis-plus-core:$mybatisplus")
}
