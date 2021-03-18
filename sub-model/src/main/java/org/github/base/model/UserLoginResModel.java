package org.github.base.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.github.base.IModel;
import org.github.base.entity.UsersEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"password", "mobile", "email", "createdTime", "updatedTime", "birthday"})
public class UserLoginResModel extends UsersEntity implements IModel {
  @Override
  public UserLoginResModel valid() {
    return this;
  }
}
