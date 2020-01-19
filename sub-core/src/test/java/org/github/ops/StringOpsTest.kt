package org.github.ops

import org.github.spring.footstone.FORMAT_DATE
import org.github.spring.footstone.FORMAT_TIME
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime

internal class StringOpsTest {
  @Test
  fun padStart() {
    assert("2333".padStart(10, ' ') == "      2333")
  }

  @Test
  fun padEnd() {
    assert("2333".padEnd(10, ' ') == "2333      ")
  }

  @Test
  fun getHexBytes() {
    val bytes = "2333".hexBytes
    assert(bytes.size == 2)
    assert(bytes[0] == 0x23.toByte())
    assert(bytes[1] == 0x33.toByte())
  }

  @Test
  fun getDate() {
    assert(LocalDate.now().toString() == SimpleDateFormat(FORMAT_DATE).format(LocalDate.now().toString().date))
  }

  @Test
  fun getTime() {
    assert(LocalDateTime.now().value == SimpleDateFormat(FORMAT_TIME).format(LocalDateTime.now().value.time))
  }

  @Test
  fun getClasspathFile() {
    assert("META-INF/sub-core.kotlin_module".classpathFile.exists())
  }
}
