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
  ${item.name?upper_case}(${item.code},"${item.label}"),
</#list>
  ;

  private final int code;

  private final String value;

  ${name}(int code, String value) {
    this.code  = code;
    this.value = value;
  }
}
