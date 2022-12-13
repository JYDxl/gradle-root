package org.github.blog.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.IBo;
import org.github.mysql.blog.entity.BlogMbpPo;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogEditBo extends BlogMbpPo implements IBo {
}
