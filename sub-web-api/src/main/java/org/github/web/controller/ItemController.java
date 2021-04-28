package org.github.web.controller;

import org.github.web.model.bo.ItemCommentBO;
import org.github.web.model.bo.ItemSearchBO;
import org.github.web.model.bo.ItemSearchByCatBO;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.spring.restful.json.JSONPageReturn;
import org.github.web.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/items/")
public class ItemController {
  @Autowired
  private IItemService itemService;

  @GetMapping("catItems")
  public Returnable catItems(ItemSearchByCatBO bo) {
    return JSONPageReturn.of(itemService.catItems(bo.valid()));
  }

  @GetMapping("commentLevel")
  public Returnable commentLevel(@RequestParam String itemId) {
    return JSONDataReturn.of(itemService.queryCommentCounts(itemId));
  }

  @GetMapping("comments")
  public Returnable comments(ItemCommentBO bo) {
    return JSONPageReturn.of(itemService.queryPagedComments(bo.valid()));
  }

  @GetMapping("info/{itemId}")
  public Returnable info(@PathVariable String itemId) {
    return itemService.queryItemById(itemId);
  }

  @GetMapping("search")
  public Returnable search(ItemSearchBO bo) {
    return JSONPageReturn.of(itemService.search(bo.valid()));
  }
}
