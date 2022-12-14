val saToken: String by System.getProperties()

dependencies {
  compileOnly(project(":sub-system-common"))
  compileOnly("cn.dev33:sa-token-spring-boot-starter:$saToken")
}
