val kotlinxcoroutines: String by System.getProperties()

dependencies {
  api("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinxcoroutines")
}
