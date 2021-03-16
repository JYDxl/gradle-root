package org.github.ops

import org.github.ops.spring.json
import org.github.ops.spring.map
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import java.util.stream.IntStream

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ObjectOpsTests {
  /** log. */
  private val log = ObjectOpsTests::class.log

  @Autowired

  @Test
  fun map() {
    val item = SysMenuTree("id", null, "name")
    val map = item.map
    log.info { map.json() }
  }

  @Test
  fun localTimeValue() {
    val value = LocalTime.now().value
    log.info { value }
  }

  @Test
  fun localDateTime() {
    val long = LocalDateTime.now().long
    log.info { long }
  }

  @Test
  fun localDateTimeDate() {
    val date = LocalDateTime.now().date
    log.info { date }
  }

  @Test
  fun localDateTimeSeconds() {
    val seconds = LocalDateTime.now().seconds
    log.info { seconds }
  }

  @Test
  fun stringHexBytes() {
    val hexBytes = "abcd".hexBytes
    log.info { hexBytes }
  }

  @Test
  fun fibonacciSequence() {
    val list = generateSequence(Triple(1, 1, 1)) { if(it.third == 10) null else Triple(it.second, it.first + it.second, it.third + 1) }.map { it.first }.toList()
    log.info { list }
  }

  @Test
  fun byteArrayHexStr() {
    val bytes = byteArrayOf(-85, -51)
    log.info { bytes.hexStr }
  }

  @Test
  fun obj() {
    log.info { Any().json() }
  }

  @Test
  fun stringTime() {
    val time = "2019-03-11 22:51:30".time
    log.info { time }
  }

  @Test
  fun stringDate() {
    val date = "2019-03-11".date
    log.info { date }
  }

  @Test
  fun format() {
    log.info { LocalDateTime.now().value }
  }

  @Test
  fun sort() {
    val random = Random(System.currentTimeMillis())
    val array = IntStream.generate { random.nextInt(100) }.limit(100).toArray()
    bubbleSort(array) { left, right -> left > right }
    log.info { array.json() }
  }

  private fun bubbleSort(array: IntArray, predicate: (left: Int, right: Int) -> Boolean) {
    val time = array.size - 1
    for(i in 0 until time) {
      for(j in 0 until time - i) {
        if(predicate(array[j], array[j + 1])) {
          val tmp = array[j]
          array[j] = array[j + 1]
          array[j + 1] = tmp
        }
      }
    }
  }

  // @Suppress("TAILREC_ON_VIRTUAL_MEMBER")
  // private tailrec fun recursive(multimap: ListMultimap<String, SysMenuTree>, list: List<SysMenuTree>) {
  //   for(node: SysMenuTree in list) {
  //     val sub: List<SysMenuTree> = multimap.get(node.id)
  //     if(sub.isNotEmpty()) {
  //       node.children = sub
  //       return recursive(multimap, sub)
  //     }
  //   }
  // }
}
