package org.github.blog.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.CodeType;
import org.github.mysql.blog.entity.BlogMbpPo;
import static org.github.center.dict.BlogStatus.BLOG_STATUS_DICT;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogDetailVo extends BlogMbpPo {
  @ApiModelProperty("博客状态名称")
  @CodeType(type = BLOG_STATUS_DICT, field = STATUS_PROP)
  private String statusName;
}
