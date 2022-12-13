package org.github.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.CodeType;
import org.github.mysql.blog.entity.BlogMbpPo;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogPageVo extends BlogMbpPo {
  @CodeType(type = BlogstaBLOG_STATUS, field = STATUS)
  private String statusName;
}
