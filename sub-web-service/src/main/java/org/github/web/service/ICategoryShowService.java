package org.github.web.service;

import org.github.web.model.dto.NoticePO;
import org.github.spring.restful.Returnable;

public interface ICategoryShowService {
  Returnable getSixNewItemsLazy(int rootCatId);

  Returnable notice(NoticePO po);

  Returnable queryAllRootCat();

  Returnable queryAllSubCat(int rootCatId);
}
