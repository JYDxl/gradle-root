package org.github.web.controller;

import org.github.web.model.dto.NoticePO;
import org.github.spring.restful.Returnable;
import org.github.web.service.ICarouselShowService;
import org.github.web.service.ICategoryShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/")
public class IndexController {
  @Autowired
  private ICarouselShowService carouselShowService;
  @Autowired
  private ICategoryShowService categoryShowService;

  @GetMapping("carousel")
  public Returnable carousel() {
    return carouselShowService.queryAll(1);
  }

  @GetMapping("cats")
  public Returnable cats() {
    return categoryShowService.queryAllRootCat();
  }

  @PostMapping("notice")
  public Returnable notice(@RequestBody NoticePO po) {
    return categoryShowService.notice(po);
  }

  @GetMapping("sixNewItems/{rootCatId}")
  public Returnable sixNewItems(@PathVariable int rootCatId) {
    return categoryShowService.getSixNewItemsLazy(rootCatId);
  }

  @GetMapping("subCat/{rootCatId}")
  public Returnable subCat(@PathVariable int rootCatId) {
    return categoryShowService.queryAllSubCat(rootCatId);
  }
}
