package org.github.extra

import com.google.common.collect.Range
import org.github.ops.minOfDay
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalTime
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
class TimeRangeTests {
  @Test
  fun test() {
    val items = arrayOf("00:00-04:00;04:00-08:00", "21:00-24:00", "12:00-17:00", "08:00-12:00;17:00-21:00")
    val treeMap: TreeMap<Range<Int>, TimeRange> = items.asSequence().flatMap { it.split(';').asSequence() }.map {
      val temp = it.split('-')
      return@map if(temp[1] != "24:00") {
        TimeRange(it, Range.closedOpen(LocalTime.parse(temp[0]).minOfDay, LocalTime.parse(temp[1]).minOfDay))
      } else {
        TimeRange(it, Range.closed(LocalTime.parse(temp[0]).minOfDay, LocalTime.parse("23:59").minOfDay))
      }
    }.associateByTo(TreeMap(Comparator.comparing<Range<Int>, Int> { it.lowerEndpoint() })) { it.range }
    assert(treeMap.size >= 4)
    var current: Range<Int> = treeMap.firstKey()
    val first = requireNotNull(treeMap[current])
    assert(first.tag.startsWith("00:00-")) { "无效的起始时间: ${first.tag}" }
    var next: Range<Int>? = treeMap.higherKey(current)
    while(next != null) {
      try {
        if(!current.intersection(next).isEmpty) throw RuntimeException()
      } catch(ignore: Exception) {
        val head = requireNotNull(treeMap[current])
        val tail = requireNotNull(treeMap[next])
        throw AssertionError("无法完全连接的时间段: ${head.tag} | ${tail.tag}")
      }
      current = next
      next = treeMap.higherKey(next)
      val head = requireNotNull(treeMap[current])
      val tail = requireNotNull(treeMap[next])
      if(next == null) assert(head.tag.endsWith("-24:00")) { "无效的结束时间: ${tail.tag}" }
    }
    println(treeMap.values.map { it.tag })
  }
}
