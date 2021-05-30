package org.github.web.cache

import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import org.github.cache.AbstractJ2Cache
import org.github.cache.CacheNameSupplier
import org.github.mysql.web.base.entity.SysMenuEntity
import org.github.mysql.web.base.enums.Enable.ENABLED
import org.github.mysql.web.base.service.ISysMenuService
import org.github.web.common.CacheName.SYS_MENU_NAME
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.function.Function
import java.util.function.Predicate

@Component
class SysMenuNameJ2Cache : AbstractJ2Cache<SysMenuEntity?, String?>() {
    @Autowired
    private lateinit var sysMenuService: ISysMenuService

    override val name: CacheNameSupplier get() = SYS_MENU_NAME

    override val mapper: Function<SysMenuEntity?, String?> get() = Function { it?.name }

    override val filter: Predicate<SysMenuEntity?> get() = Predicate { it != null && ENABLED.code == it.enabled }

    override fun load(keys: Collection<String>): Map<String, SysMenuEntity?> {
        val query: KtQueryChainWrapper<SysMenuEntity> = sysMenuService.ktQuery()
        query.`in`(keys.isNotEmpty(), SysMenuEntity::menuId, keys.map { it.toLong() })
        query.select(SysMenuEntity::menuId, SysMenuEntity::name, SysMenuEntity::enabled)
        val list: List<SysMenuEntity> = query.list()
        return list.associateBy { it.menuId.toString() }
    }
}
