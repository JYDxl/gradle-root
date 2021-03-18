package org.github.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.github.base.service.IUsersService;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class StuController {
  @Autowired
  private IUsersService usersService;

  @GetMapping("/stu/{id}")
  public Returnable getStu(@PathVariable String id) {
    return JSONData.of(usersService.getById(id));
  }
}
