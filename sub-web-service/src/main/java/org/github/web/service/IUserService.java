package org.github.web.service;

import org.github.base.model.UserLoginReqModel;
import org.github.base.model.UserRegisterModel;
import org.github.spring.restful.Returnable;

public interface IUserService {
  Returnable createUser(UserRegisterModel user);

  Returnable login(UserLoginReqModel model);

  Returnable queryUserNameIsExist(String userName);
}
