val mybatisPlus: String by System.getProperties()
val swagger: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-core"))

  compileOnly("io.springfox:springfox-boot-starter:$swagger")

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisPlus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")
}
