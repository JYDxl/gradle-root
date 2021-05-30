package org.github.controller

import org.springframework.beans.factory.annotation.Autowired
import org.github.web.module.sys.menu.service.IMenuService
import org.github.spring.restful.Returnable
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO
import org.github.mysql.web.base.entity.SysMenuEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/sys/menu/")
@RestController
class MenuController {
    @Autowired
    private lateinit var menuService: IMenuService

    @PostMapping("del")
    fun delMenuList(@RequestBody ids: List<Long>): Returnable {
        return menuService.delMenuList(ids)
    }

    @GetMapping("info/{menuId}")
    fun queryMenuInfo(@PathVariable menuId: Long): Returnable {
        return menuService.queryMenuInfo(menuId)
    }

    @PostMapping("list")
    fun queryMenuPage(@RequestBody bo: QueryMenuListBO): Returnable {
        return menuService.queryMenuPage(bo)
    }

    @PostMapping("select")
    fun queryMenuTree(): Returnable {
        return menuService.queryMenuTree()
    }

    @PostMapping("save", "update")
    fun saveOrUpdate(@RequestBody bo: SysMenuEntity): Returnable {
        return menuService.saveOrUpdate(bo)
    }
}
