// package org.github.center.service
//
// import org.github.center.bo.QueryMenuListBO
// import org.github.center.vo.QueryMenuListVO
// import org.github.mysql.sccore.base.entity.SysMenuEntity
// import org.github.spring.restful.json.JSONArrayReturn
// import org.github.spring.restful.json.JSONDataReturn
// import org.github.spring.restful.json.JSONPageReturn
//
// interface IMenuService {
//   fun delMenuList(ids: List<Long>): JSONDataReturn<Boolean>
//
//   fun queryMenuInfo(menuId: Long): JSONDataReturn<SysMenuEntity?>
//
//   fun queryMenuPage(bo: QueryMenuListBO): JSONPageReturn<QueryMenuListVO>
//
//   fun queryMenuTree(): JSONArrayReturn<SysMenuEntity>
//
//   fun saveOrUpdate(bo: SysMenuEntity): JSONDataReturn<Boolean>
// }
