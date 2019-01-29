package org.github.ops

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ListMultimap
import org.github.base.service.ISysMenuService
import org.github.base.service.ITipLoginLogService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ActiveProfiles("dev", "test")
@SpringBootTest
class ObjectOpsTests {
  @Autowired
  private lateinit var tipLoginLogService: ITipLoginLogService

  @Autowired
  private lateinit var sysMenuService: ISysMenuService

  @Test
  fun json() {
    log.info(tipLoginLogService.list().json())
  }

  @Test
  fun recursive() {
    val list: List<SysMenuTree> = sysMenuService.list().map { SysMenuTree(it.menuId, it.pid, it.menuName) }
    val multimap: ListMultimap<String, SysMenuTree> = ArrayListMultimap.create<String, SysMenuTree>().apply { list.forEach { this.put(it.pid, it) } }
    val result: List<SysMenuTree> = ArrayList(multimap.get(null))
    recursive(multimap, result)
    log.info(result.json())
  }

  private tailrec fun recursive(multimap: ListMultimap<String, SysMenuTree>, list: List<SysMenuTree>) {
    for (node in list) {
      val subNodes: List<SysMenuTree> = multimap.get(node.id)
      if (subNodes.isNotEmpty()) {
        node.children = subNodes
        return recursive(multimap, subNodes)
      }
    }
  }

  companion object {
    private val log = ObjectOpsTests::class.log
  }
}
