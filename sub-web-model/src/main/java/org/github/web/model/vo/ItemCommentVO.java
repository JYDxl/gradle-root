package org.github.web.model.vo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ItemCommentVO {
  private Integer       commentLevel;
  private String        content;
  private String        specName;
  private LocalDateTime createdTime;
  private String        userFace;
  private String        nickname;

  public String getNickname() {
    return "";
  }
}
