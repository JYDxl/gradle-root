package org.github.blog.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.CodeType;
import org.github.mysql.blog.entity.BlogMbpPo;
import static org.github.center.dict.BlogStatus.BLOG_STATUS;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogPageVo extends BlogMbpPo {
  @CodeType(type = BLOG_STATUS, field = STATUS)
  private String statusName;
}
