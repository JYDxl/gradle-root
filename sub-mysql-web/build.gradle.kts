val mybatisplus: String by System.getProperties()
val swagger: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-core"))

  compileOnly("io.springfox:springfox-boot-starter:$swagger")

  api("com.baomidou:mybatis-plus-annotation:$mybatisplus")
  api("com.baomidou:mybatis-plus-extension:$mybatisplus")
}
