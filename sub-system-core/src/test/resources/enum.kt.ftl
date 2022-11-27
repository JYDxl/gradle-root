package ${pack}

import org.github.base.BaseEnum

/**
 * ${type.dictName} ${type.dictInfo}
 *
 * @author JYD_XL
 */
enum class ${name}(override val code: String, override val value: String): BaseEnum {
<#list list as item>
  /** ${item.itemName} ${item.itemInfo} */
  ${item.itemCode?upper_case}("${item.itemCode}","${item.itemName}"),
</#list>
}
