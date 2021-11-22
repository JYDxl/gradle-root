package ${pack}

import org.github.base.BaseEnum

enum class ${name}(override val code: String, override val value: String): BaseEnum {
<#list list as item>
  <#if item.intro?has_content>
    /** ${item.intro} */
  <#else>
    /** ${item.label} */
  </#if>
  ${item.name?upper_case}("${item.name}","${item.label}"),
</#list>
}
