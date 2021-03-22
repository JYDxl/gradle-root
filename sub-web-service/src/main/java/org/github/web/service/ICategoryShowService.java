package org.github.web.service;

import org.github.spring.restful.Returnable;

public interface ICategoryShowService {
  Returnable getSixNewItemsLazy(int rootCatId);

  Returnable queryAllRootCat();

  Returnable queryAllSubCat(int rootCatId);
}
