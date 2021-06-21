package org.github.ops

import org.github.spring.ops.json
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import java.util.stream.IntStream

@ExtendWith(SpringExtension::class)
@SpringBootTest
class ObjectOpsTests {
  /** log. */
  private val log = ObjectOpsTests::class.log

  @Autowired

  @Test
  fun fibonacciSequence() {
    val list = generateSequence(Triple(1, 1, 1)) {if (it.third == 10) null else Triple(it.second, it.first + it.second, it.third + 1)}.map {it.first}.toList()
    log.info {list}
  }

  @Test
  fun obj() {
    log.info {Any().json()}
  }

  @Test
  fun sort() {
    val random = Random(System.currentTimeMillis())
    val array = IntStream.generate {random.nextInt(100)}.limit(100).toArray()
    bubbleSort(array) {left, right -> left > right}
    log.info {array.json()}
  }

  private fun bubbleSort(array: IntArray, predicate: (left: Int, right: Int) -> Boolean) {
    val time = array.size - 1
    for (i in 0 until time) {
      for (j in 0 until time - i) {
        if (predicate(array[j], array[j + 1])) {
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
