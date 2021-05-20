package org.github.controller;

import lombok.extern.slf4j.Slf4j;
import org.github.web.model.UserLoginReqModel;
import org.github.web.model.UserRegisterReqModel;
import org.github.spring.restful.Returnable;
import org.github.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/passport/")
public class PassportController {
  @Autowired
  private IUserService usersService;

  @PostMapping("login")
  public Returnable login(@RequestBody UserLoginReqModel model) {
    return usersService.login(model.valid());
  }

  @PostMapping("logout")
  public Returnable logout(@RequestParam String userId) {
    return usersService.logout(userId);
  }

  @PostMapping("regist")
  public Returnable register(@RequestBody UserRegisterReqModel model) {
    return usersService.createUser(model.valid());
  }

  @GetMapping("usernameIsExist")
  public Returnable userNameIsExist(@RequestParam String username) {
    return usersService.queryUserNameIsExist(username);
  }
}
