package org.github.leadnews.article.dto;

import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.github.base.IParam;
import org.github.base.PageParam;
import static java.time.LocalDateTime.*;
import static java.util.Collections.*;
import static org.github.leadnews.article.enums.ArticleHomeLoadType.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ArticleHomeLoadBO extends PageParam implements IParam {
  @Nullable
  private Integer       provinceId;
  @Nullable
  private Integer       cityId;
  @Nullable
  private Integer       countryId;
  @NotNull
  private LocalDateTime time          = now();
  @NotNull
  private String        tag           = "";
  @NotNull
  private Integer       type          = LOAD_MORE.getCode();
  @NotNull
  private List<Long>    articleIdList = emptyList();
}
