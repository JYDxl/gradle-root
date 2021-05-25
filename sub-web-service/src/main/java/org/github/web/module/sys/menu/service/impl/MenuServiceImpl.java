package org.github.web.module.sys.menu.service.impl;

import lombok.NonNull;
import lombok.val;
import org.github.base.Page;
import org.github.cache.RAMCache;
import org.github.mysql.web.base.entity.SysMenuEntity;
import org.github.mysql.web.base.service.ISysMenuService;
import org.github.spring.restful.json.JSONArrayReturn;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.spring.restful.json.JSONPageReturn;
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO;
import org.github.web.module.sys.menu.model.vo.QueryMenuListVO;
import org.github.web.module.sys.menu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.hutool.core.text.CharSequenceUtil.isNotBlank;
import static org.github.mysql.web.base.enums.MenuType.button;
import static org.github.mysql.web.base.enums.MenuType.directory;
import static org.github.web.common.CacheName.sysMenuName;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class MenuServiceImpl implements IMenuService {
  @Autowired
  private ISysMenuService sysMenuService;
  @Autowired
  private RAMCache        ramCache;

  @Override
  public @NonNull JSONDataReturn<Boolean> delMenuList(@NonNull List<Long> ids) {
    if (ids.isEmpty()) return JSONDataReturn.of(false);
    val result = sysMenuService.removeByIds(ids);
    return JSONDataReturn.of(result);
  }

  @Override
  public @NonNull JSONDataReturn<SysMenuEntity> queryMenuInfo(@NonNull Long menuId) {
    val entity = sysMenuService.getById(menuId);
    return JSONDataReturn.of(entity);
  }

  @Override
  public @NonNull JSONPageReturn<QueryMenuListVO> queryMenuPage(@NonNull QueryMenuListBO bo) {
    val query = sysMenuService.lambdaQuery();
    query.likeRight(isNotBlank(bo.getName()), SysMenuEntity::getName, bo.getName());
    val page = query.page(new Page<>(bo));
    val list = page.getRecords();
    if (list.isEmpty()) return JSONPageReturn.of(page);
    return JSONPageReturn.of(page, this::applySysMenuEntity2QueryMenuListVO);
  }

  @Override
  public @NonNull JSONArrayReturn<SysMenuEntity> queryMenuTree() {
    val query = sysMenuService.lambdaQuery();
    query.ne(SysMenuEntity::getType, button.getCode());
    val list = query.list();

    val root = new SysMenuEntity();
    root.setMenuId(0L);
    root.setParentId(-1L);
    root.setName("根目录");
    // root.setUrl();
    // root.setPerms();
    root.setType(directory.getCode());
    root.setIcon("fa fa-car");
    root.setOrderNum(0);
    list.add(root);

    return JSONArrayReturn.of(list);
  }

  @Override
  public @NonNull JSONDataReturn<Boolean> saveOrUpdate(@NonNull SysMenuEntity bo) {
    val result = sysMenuService.saveOrUpdate(bo);
    return JSONDataReturn.of(result);
  }

  private @NonNull QueryMenuListVO applySysMenuEntity2QueryMenuListVO(@NonNull SysMenuEntity entity) {
    val vo = new QueryMenuListVO();
    copyProperties(entity, vo);
    vo.setParentName(ramCache.<String>getCache(sysMenuName).get(vo.getParentId()));
    return vo;
  }
}
