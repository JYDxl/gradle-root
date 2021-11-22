package ${pack};

import org.github.base.BaseEnum;

@lombok.Getter
public enum ${name} implements BaseEnum {
<#list list as item>
  <#if item.intro?has_content>
    /** ${item.intro} */
  <#else>
    /** ${item.label} */
  </#if>
  ${item.name?upper_case}("${item.name}","${item.label}"),
</#list>
  ;

  private final String code;

  private final String value;

  ${name}(String code, String value) {
    this.code  = code;
    this.value = value;
  }
}
