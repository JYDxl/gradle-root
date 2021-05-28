package org.github.web.module.sys.menu.service;

import lombok.NonNull;
import org.github.mysql.web.base.entity.SysMenuMbpEntity;
import org.github.spring.restful.json.JSONArrayReturn;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.spring.restful.json.JSONPageReturn;
import org.github.web.module.sys.menu.model.bo.QueryMenuListBO;
import org.github.web.module.sys.menu.model.vo.QueryMenuListVO;

import java.util.List;

public interface IMenuService {
  @NonNull JSONDataReturn<Boolean> delMenuList(@NonNull List<Long> ids);

  @NonNull JSONDataReturn<SysMenuMbpEntity> queryMenuInfo(@NonNull Long menuId);

  @NonNull JSONPageReturn<QueryMenuListVO> queryMenuPage(@NonNull QueryMenuListBO bo);

  @NonNull JSONArrayReturn<SysMenuMbpEntity> queryMenuTree();

  @NonNull JSONDataReturn<Boolean> saveOrUpdate(@NonNull SysMenuMbpEntity bo);
}
