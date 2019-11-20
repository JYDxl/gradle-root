package ${package.Mapper}

import ${superMapperClassPackage}
import ${package.Entity}.${entity}
import org.github.mybatis.MyBatisMapper

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
@MyBatisMapper
interface ${table.mapperName}: ${superMapperClass}<${entity}>
</#if>
