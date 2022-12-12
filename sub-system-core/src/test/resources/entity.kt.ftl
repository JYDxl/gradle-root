@file:Suppress("UnusedImport", "unused", "KotlinConstantConditions")

package ${package.Entity}

<#list table.importPackages as pkg>
import ${pkg}
</#list>
<#if swagger>
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
</#if>

/**
 * ${table.comment}
 *
 * @author ${author}
 */
<#if table.convert>
@TableName("${schemaName}${table.name}")
</#if>
<#if swagger>
@ApiModel("${table.comment!}")
</#if>
<#if superEntityClass??>
open class ${entity} : ${superEntityClass}<#if activeRecord><${entity}></#if>() {
<#elseif activeRecord>
open class ${entity} : Model<${entity}>() {
<#else>
open class ${entity} : Serializable {
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#if field.keyFlag>
    <#assign keyPropertyName="${field.propertyName}"/>
</#if>

<#if swagger>
    @ApiModelProperty("${field.comment}")
</#if>
<#if field.keyFlag>
<#-- 主键 -->
<#if field.keyIdentityFlag>
    @TableId(value = "${field.annotationColumnName}", type = IdType.AUTO)
<#elseif idType ??>
    @TableId(value = "${field.annotationColumnName}", type = IdType.${idType})
<#elseif field.convert>
    @TableId("${field.annotationColumnName}")
</#if>
<#-- 普通字段 -->
<#elseif field.fill??>
<#-- -----   存在字段填充设置   ----->
<#if field.convert>
    @TableField(value = "${field.annotationColumnName}", fill = FieldFill.${field.fill})
<#else>
    @TableField(fill = FieldFill.${field.fill})
</#if>
<#elseif field.convert>
    @TableField("${field.annotationColumnName}")
</#if>
<#-- 乐观锁注解 -->
<#if field.versionField>
    @Version
</#if>
<#-- 逻辑删除注解 -->
<#if field.logicDeleteField>
    @TableLogic
</#if>
    <#if field.propertyType == "Integer">
    open var ${field.propertyName}: Int? = null
    <#elseif field.propertyType == "byte[]">
    open var ${field.propertyName}: ByteArray? = null
    <#else>
    open var ${field.propertyName}: ${field.propertyType}? = null
    </#if>
</#list>
<#-- ----------  END 字段循环遍历  ---------->

    companion object {

        private const val serialVersionUID = 1L
<#if entityColumnConstant>
<#list table.fields as field>

        const val ${field.name?upper_case} : String = "${field.name}"
</#list>
</#if>

    }

    override fun pkVal(): Serializable? {
<#if keyPropertyName??>
        return ${keyPropertyName}
<#else>
        return null
</#if>
    }

    override fun toString(): String {
        return get()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ${entity}) return false
        <#list table.fields as field>
        if (${field.name} != other.${field.name}) return false
        </#list>
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        <#list table.fields as field>
        result = 31 * result + (${field.name}?.hashCode() ?: 0)
        </#list>
        return result
    }

}
