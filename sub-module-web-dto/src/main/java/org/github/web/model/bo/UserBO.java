package org.github.web.model.bo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class UserBO {
  private String id;

  @NotBlank(message = "用户名不能为空")
  @Length(min = 5, max = 8, message = "用户名长度不在4-8之间")
  private String name;

  @NotNull(message = "密码不能为空")
  @Pattern(regexp = "[0-9]\\d+", message = "密码不符合规范")
  private String password;

  @NotNull(message = "年龄不能为空")
  @Range(min = 1, max = 200, message = "年龄值不太正常")
  private Integer age;

  @Max(value = 10, message = "级别超过最大值了")
  @Min(value = 1, message = "级别低于最小值")
  private Integer level;

  private String mobile;
}
