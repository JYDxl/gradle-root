package ${pack}

import org.github.base.BaseEnum

enum class ${name}(override val code: Int, override val value: String): BaseEnum {
<#list list as item>
  <#if item.intro?has_content>
    /** ${item.intro} */
  <#else>
    /** ${item.label} */
  </#if>
  ${item.name?upper_case}(${item.code},"${item.label}"),
</#list>
}
