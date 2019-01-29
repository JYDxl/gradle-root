package org.github.ops

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableListMultimap
import org.github.base.service.ISysMenuService
import org.github.base.service.ITipLoginLogService
import org.github.spring.footstone.EMPTY
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
    val list = sysMenuService.list().map { SysMenuTree(it.menuId, it.pid, it.menuName) }
    val multimap: ImmutableListMultimap<String, SysMenuTree> = ImmutableListMultimap.builder<String, SysMenuTree>().apply { list.forEach { put(it.pid.orEmpty(), it) } }.build()
    val result: ImmutableList<SysMenuTree> = multimap.get(EMPTY)
    recursive(multimap, result)
    log.info(result.json())
  }

  private tailrec fun recursive(multimap: ImmutableListMultimap<String, SysMenuTree>, list: ImmutableList<SysMenuTree>) {
    for (node: SysMenuTree in list) {
      val subNodes: ImmutableList<SysMenuTree> = multimap.get(node.id)
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
