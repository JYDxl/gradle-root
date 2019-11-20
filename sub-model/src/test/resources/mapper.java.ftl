package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@MyBatisMapper
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {}
</#if>
