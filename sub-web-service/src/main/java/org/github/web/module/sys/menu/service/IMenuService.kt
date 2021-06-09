package org.github.web.module.sys.menu.service

import org.github.spring.restful.json.JSONDataReturn
import org.github.mysql.mydb.base.entity.SysMenuEntity
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO
import org.github.spring.restful.json.JSONPageReturn
import org.github.web.module.sys.menu.model.vo.QueryMenuListVO
import org.github.spring.restful.json.JSONArrayReturn

interface IMenuService {
  fun delMenuList(ids: List<Long>): JSONDataReturn<Boolean>

  fun queryMenuInfo(menuId: Long): JSONDataReturn<SysMenuEntity?>

  fun queryMenuPage(bo: QueryMenuListBO): JSONPageReturn<QueryMenuListVO>

  fun queryMenuTree(): JSONArrayReturn<SysMenuEntity>

  fun saveOrUpdate(bo: SysMenuEntity): JSONDataReturn<Boolean>
}
