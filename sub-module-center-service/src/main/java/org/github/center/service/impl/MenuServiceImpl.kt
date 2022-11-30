package org.github.center.service.impl

import org.github.center.bo.QueryMenuListBO
import org.github.center.mapper.IMenuMapper
import org.github.center.service.IMenuService
import org.github.center.vo.QueryMenuListVO
import org.github.mysql.sccore.base.entity.SysMenuEntity
import org.github.mysql.sccore.base.service.ISysMenuService
import org.github.spring.restful.json.JSONArrayReturn
import org.github.spring.restful.json.JSONDataReturn
import org.github.spring.restful.json.JSONPageReturn
import org.springframework.beans.factory.annotation.Autowired
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
    val entity: SysMenuEntity? = sysMenuService.getById(menuId)
    return JSONDataReturn.of(entity)
  }

  override fun queryMenuPage(bo: QueryMenuListBO): JSONPageReturn<QueryMenuListVO> {
    val page = menuMapper.queryPage(bo.page(), bo)
    return JSONPageReturn.of(page)
  }

  override fun queryMenuTree(): JSONArrayReturn<SysMenuEntity> {
    // val query = sysMenuService.ktQueryWrapper()
    // query.ne(SysMenuEntity::type, BUTTON.code)
    // val list = query.ktList()
    // val root = SysMenuEntity()
    // root.menuId = 0L
    // root.parentId = -1L
    // root.name = "根目录"
    // // root.setUrl();
    // // root.setPerms();
    // root.type = DIRECTORY.code
    // root.icon = "fa fa-car"
    // root.orderNum = 0
    // list.add(root)
    // return JSONArrayReturn.of(list)
    return JSONArrayReturn.of()
  }

  override fun saveOrUpdate(bo: SysMenuEntity): JSONDataReturn<Boolean> {
    val result = sysMenuService.saveOrUpdate(bo)
    return JSONDataReturn.of(result)
  }
}
