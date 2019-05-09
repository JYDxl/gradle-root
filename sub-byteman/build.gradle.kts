val byteman: String by System.getProperties()

dependencies {
  api("org.jboss.byteman:byteman:$byteman")
}
