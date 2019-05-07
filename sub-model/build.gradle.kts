val mybatisPlus: String by System.getProperties()

dependencies {
  implementation(project(":sub-core"))

  testImplementation("com.baomidou:mybatis-plus-generator:$mybatisPlus")
  testImplementation("org.freemarker:freemarker")
}
