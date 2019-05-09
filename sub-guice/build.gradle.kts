val guice: String by System.getProperties()

dependencies {
  api("com.google.inject:guice:$guice")
}
