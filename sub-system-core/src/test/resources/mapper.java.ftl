<#if kotlin>
@file:Suppress("RedundantSemicolon")

</#if>
package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.github.core.mybatis.MyBatisMapper;

/**
 * ${table.comment!} Mapper 接口
 *
 * @author ${author}
 */
@MyBatisMapper
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {}
</#if>
