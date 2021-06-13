package org.github.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.github.mysql.mydb.base.entity.SysMenuEntity
import org.github.ops.trimStrFields
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO
import org.github.web.module.sys.menu.service.IMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["菜单管理"])
@RequestMapping("/sys/menu/")
@RestController
class MenuController {
  @Autowired
  private lateinit var menuService: IMenuService

  @ApiOperation("删除菜单")
  @PostMapping("del")
  fun delMenuList(@RequestBody ids: Array<Long>) = menuService.delMenuList(ids.toList())

  @GetMapping("info/{menuId}")
  fun queryMenuInfo(@PathVariable menuId: Long) = menuService.queryMenuInfo(menuId)

  @ApiOperation("分页查询")
  @PostMapping("page")
  fun queryMenuPage(@RequestBody bo: QueryMenuListBO) = menuService.queryMenuPage(bo.trimStrFields())

  @PostMapping("select")
  fun queryMenuTree() = menuService.queryMenuTree()

  @ApiOperation("新增/修改")
  @PostMapping("save", "update")
  fun saveOrUpdate(@RequestBody bo: SysMenuEntity) = menuService.saveOrUpdate(bo.trimStrFields())
}
