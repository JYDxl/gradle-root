package org.github.web.module.sys.menu.service.impl

import org.github.web.module.sys.menu.service.IMenuService
import org.springframework.beans.factory.annotation.Autowired
import org.github.mysql.web.base.service.ISysMenuService
import org.github.cache.RAMCache
import org.github.spring.restful.json.JSONDataReturn
import org.github.mysql.web.base.entity.SysMenuEntity
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO
import org.github.spring.restful.json.JSONPageReturn
import org.github.web.module.sys.menu.model.vo.QueryMenuListVO
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import org.github.base.Page
import org.github.spring.restful.json.JSONArrayReturn
import org.github.mysql.web.base.enums.MenuType
import org.github.mysql.web.base.enums.MenuType.button
import org.github.ops.isNotBlank
import org.github.web.common.CacheName.sysMenuName
import org.springframework.beans.BeanUtils.copyProperties
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl : IMenuService {
    @Autowired
    private lateinit var sysMenuService: ISysMenuService

    @Autowired
    private lateinit var ramCache: RAMCache

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
        val query: KtQueryChainWrapper<SysMenuEntity> = sysMenuService.ktQuery()
        query.likeRight(bo.name.isNotBlank(), SysMenuEntity::name, bo.name)
        val page: Page<SysMenuEntity> = query.page(Page(bo))
        val list: List<SysMenuEntity> = page.records
        if (list.isEmpty()) return JSONPageReturn.of(page)
        return JSONPageReturn.of(page) { applySysMenuEntity2QueryMenuListVO(it) }
    }

    override fun queryMenuTree(): JSONArrayReturn<SysMenuEntity> {
        val query: KtQueryChainWrapper<SysMenuEntity> = sysMenuService.ktQuery()
        query.ne(SysMenuEntity::type, button.code)
        val list: MutableList<SysMenuEntity> = query.list()
        val root = SysMenuEntity()
        root.menuId = 0L
        root.parentId = -1L
        root.name = "根目录"
        // root.setUrl();
        // root.setPerms();
        root.type = MenuType.directory.code
        root.icon = "fa fa-car"
        root.orderNum = 0
        list.add(root)
        return JSONArrayReturn.of(list)
    }

    override fun saveOrUpdate(bo: SysMenuEntity): JSONDataReturn<Boolean> {
        val result = sysMenuService.saveOrUpdate(bo)
        return JSONDataReturn.of(result)
    }

    private fun applySysMenuEntity2QueryMenuListVO(entity: SysMenuEntity) = QueryMenuListVO().apply {
        copyProperties(entity, this)
        parentName = ramCache.getCache<String>(sysMenuName).get(parentId)
    }
}
