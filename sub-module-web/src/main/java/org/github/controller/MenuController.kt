package org.github.controller

import cn.hutool.core.bean.BeanUtil.trimStrFields
import org.github.sso.module.sys.menu.dto.QueryMenuListBO
import org.github.sso.module.sys.menu.dto.SaveOrUpdateMenuBO
import org.github.web.module.sys.menu.service.IMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/sys/menu/")
@RestController
class MenuController {
  @Autowired
  private lateinit var menuService: IMenuService

  @PostMapping("del")
  fun delMenuList(@RequestBody ids: Array<Long>) = menuService.delMenuList(ids.toList())

  @GetMapping("info/{menuId}")
  fun queryMenuInfo(@PathVariable menuId: Long) = menuService.queryMenuInfo(menuId)

  @PostMapping("page")
  fun queryMenuPage(@RequestBody bo: QueryMenuListBO) = menuService.queryMenuPage(trimStrFields(bo))

  @PostMapping("select")
  fun queryMenuTree() = menuService.queryMenuTree()

  @PostMapping("save", "update")
  fun saveOrUpdate(@RequestBody bo: SaveOrUpdateMenuBO) = menuService.saveOrUpdate(trimStrFields(bo))
}
