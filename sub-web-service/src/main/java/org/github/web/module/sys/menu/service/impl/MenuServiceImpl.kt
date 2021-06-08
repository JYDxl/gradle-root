package org.github.web.module.sys.menu.service.impl

import org.github.web.module.sys.menu.service.IMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.github.mysql.web.base.service.ISysMenuService
import org.github.spring.restful.json.JSONDataReturn
import org.github.mysql.web.base.entity.SysMenuEntity
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO
import org.github.spring.restful.json.JSONPageReturn
import org.github.web.module.sys.menu.model.vo.QueryMenuListVO
import org.github.base.Page
import org.github.mybatis.ops.ktGetById
import org.github.mybatis.ops.ktList
import org.github.mybatis.ops.ktQueryWrapper
import org.github.spring.restful.json.JSONArrayReturn
import org.github.mysql.web.base.dict.MenuType.BUTTON
import org.github.mysql.web.base.dict.MenuType.DIRECTORY
import org.github.web.module.sys.menu.mapper.IMenuMapper
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl: IMenuService {
  @Autowired
  private lateinit var sysMenuService: ISysMenuService
  @Autowired
  private lateinit var menuMapper: IMenuMapper

  override fun delMenuList(ids: List<Long>): JSONDataReturn<Boolean> {
    if (ids.isEmpty()) return JSONDataReturn.of(false)
    val result = sysMenuService.removeByIds(ids)
    return JSONDataReturn.of(result)
  }

  override fun queryMenuInfo(menuId: Long): JSONDataReturn<SysMenuEntity?> {
    val entity = sysMenuService.ktGetById(menuId)
    return JSONDataReturn.of(entity)
  }

  override fun queryMenuPage(bo: QueryMenuListBO): JSONPageReturn<QueryMenuListVO> {
    val page = menuMapper.queryPage(Page(bo), bo)
    return JSONPageReturn.of(page)
  }

  override fun queryMenuTree(): JSONArrayReturn<SysMenuEntity> {
    val query = sysMenuService.ktQueryWrapper()
    query.ne(SysMenuEntity::type, BUTTON.code)
    val list = query.ktList()
    val root = SysMenuEntity()
    root.menuId = 0L
    root.parentId = -1L
    root.name = "根目录"
    // root.setUrl();
    // root.setPerms();
    root.type = DIRECTORY.code
    root.icon = "fa fa-car"
    root.orderNum = 0
    list.add(root)
    return JSONArrayReturn.of(list)
  }

  override fun saveOrUpdate(bo: SysMenuEntity): JSONDataReturn<Boolean> {
    val result = sysMenuService.saveOrUpdate(bo)
    return JSONDataReturn.of(result)
  }
}
