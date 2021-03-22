package org.github.web.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.github.base.entity.CarouselEntity;
import org.github.base.service.ICarouselService;
import org.github.spring.restful.Returnable;
import org.github.spring.restful.json.JSONArrayReturn;
import org.github.web.service.ICarouselShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import static org.springframework.transaction.annotation.Propagation.*;

@Service
@Slf4j
public class CarouselShowServiceImpl implements ICarouselShowService {
  @Autowired
  private ICarouselService carouselService;

  @Transactional(propagation = SUPPORTS, readOnly = true)
  @Override
  public Returnable queryAll(int isShow) {
    LambdaQueryWrapper<CarouselEntity> query = Wrappers.lambdaQuery();
    query
      .eq(CarouselEntity::getIsShow, isShow)
      .orderByDesc(CarouselEntity::getSort)
    ;
    List<CarouselEntity> list = carouselService.list(query);
    return JSONArrayReturn.of(list);
  }
}
