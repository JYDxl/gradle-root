val javassist: String by System.getProperties()

dependencies {
  api("org.javassist:javassist:$javassist")
}
