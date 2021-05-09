package org.github.web.module.sys.menu.controller;

import java.util.List;
import org.github.base.entity.SysMenuEntity;
import org.github.spring.restful.Returnable;
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO;
import org.github.web.module.sys.menu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sys/menu/")
@Controller
public class MenuController {
  @Autowired
  private IMenuService menuService;

  @PostMapping("del")
  public Returnable delMenuList(@RequestBody List<Long> ids) {
    return menuService.delMenuList(ids);
  }

  @GetMapping("info/{menuId}")
  public Returnable queryMenuInfo(@PathVariable Long menuId) {
    return menuService.queryMenuInfo(menuId);
  }

  @PostMapping("list")
  public Returnable queryMenuList(@RequestBody QueryMenuListBO bo) {
    return menuService.queryMenuList(bo);
  }

  @PostMapping("select")
  public Returnable queryMenuTree() {
    return menuService.queryMenuTree();
  }

  @PostMapping({"save", "update"})
  public Returnable saveOrUpdate(@RequestBody SysMenuEntity bo) {
    return menuService.saveOrUpdate(bo);
  }
}
