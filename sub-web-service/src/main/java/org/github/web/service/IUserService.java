package org.github.web.service;

import org.github.web.model.UserLoginReqModel;
import org.github.web.model.UserRegisterReqModel;
import org.github.spring.restful.Returnable;

public interface IUserService {
  Returnable createUser(UserRegisterReqModel user);

  Returnable login(UserLoginReqModel model);

  Returnable logout(String userId);

  Returnable queryUserNameIsExist(String userName);
}
