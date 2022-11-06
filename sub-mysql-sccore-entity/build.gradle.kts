val mybatisPlus: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-core"))

  compileOnly("com.baomidou:mybatis-plus-annotation:$mybatisPlus")
  compileOnly("com.baomidou:mybatis-plus-extension:$mybatisPlus")
}
