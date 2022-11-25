package ${pack}

import org.github.base.BaseEnum

/**
 * ${type}
 *
 * @author JYD_XL
 */
enum class ${name}(override val code: String, override val value: String): BaseEnum {
<#list list as item>
  <#if item.info?has_content>
    /** ${item.info} */
  <#else>
    /** ${item.name} */
  </#if>
  ${item.code?upper_case}("${item.code}","${item.name}"),
</#list>
}
