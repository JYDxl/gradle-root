package org.github.blog.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.github.core.base.IBo;
import org.github.core.base.PageBo;

@EqualsAndHashCode(callSuper = true)
@Data
public class BlogPageBo extends PageBo implements IBo {
}
