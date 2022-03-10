package org.github.util.tree;

import java.util.List;
import lombok.*;
import lombok.extern.slf4j.*;
import org.github.mysql.mydb.base.entity.TabSafeQuestionDataEntity;
import org.github.mysql.mydb.base.entity.TabSafeQuestionTypeEntity;
import org.github.mysql.mydb.base.service.ITabSafeQuestionDataService;
import org.github.mysql.mydb.base.service.ITabSafeQuestionTypeService;
import org.github.web.model.vo.TreeVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.Lists.*;
import static java.util.Objects.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static org.github.spring.ops.SpringKt.*;
import static org.github.util.tree.TreeUtil.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class TreeUtilTest {
  @Autowired
  ITabSafeQuestionTypeService safeQuestionTypeService;
  @Autowired
  ITabSafeQuestionDataService safeQuestionDataService;

  @NonNull TreeVO applyTabSafeQuestionDataEntity2TreeVO(@NonNull TabSafeQuestionDataEntity data) {
    val vo = new TreeVO(data.getQuestionTypeId(), requireNonNull(data.getId()), requireNonNull(data.getCheckContent()));
    vo.setLeaf(true);
    return vo;
  }

  @NonNull TreeVO applyTabSafeQuestionTypeEntity2TreeVO(@NonNull TabSafeQuestionTypeEntity type) {
    val vo = new TreeVO(type.getParentId(), requireNonNull(type.getId()), requireNonNull(type.getTypeName()));
    vo.setLeaf(false);
    return vo;
  }

  @Test
  void buildTreeTest() {
    val typeQuery = safeQuestionTypeService.lambdaQuery();
    typeQuery.eq(TabSafeQuestionTypeEntity::getProjectId, "-1");
    val typeList   = typeQuery.list();
    val typeStream = typeList.stream().map(this::applyTabSafeQuestionTypeEntity2TreeVO);

    val dataQuery = safeQuestionDataService.lambdaQuery();
    dataQuery.eq(TabSafeQuestionDataEntity::getProjectId, "-1");
    dataQuery.eq(TabSafeQuestionDataEntity::isUse, 0);
    val dataList   = dataQuery.list();
    val dataStream = dataList.stream().map(this::applyTabSafeQuestionDataEntity2TreeVO);

    val list = concat(typeStream, dataStream).collect(toList());
    reduceList(list);

    val tree = buildTree(list, "", null);
    val json = json(tree);
    log.info(json);
  }

  void reduceList(List<TreeVO> list) {
    val pidList = list.stream().map(TreeVO::getPid).collect(toImmutableList());
    val subList = list.stream().filter(v -> !pidList.contains(v.getId())).filter(v -> !v.isLeaf()).collect(toImmutableList());
    if (subList.isEmpty()) return;
    list.removeAll(subList);
    reduceList(list);
  }

  @Test
  void testReduce() {
    val list = newArrayList(
      new CollectVO(0, 1, 1, 1, "2021-04-25"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 1, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-25"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 1, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 0, 1, 1, "2021-04-23"),
      new CollectVO(0, 1, 1, 1, "2021-04-16"),
      new CollectVO(1, 0, 1, 1, "2021-04-23"),
      new CollectVO(1, 0, 1, 1, "2021-04-16"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-25"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-19"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-16"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-14"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-23"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-15"),
      new CollectVO(0, 0, 0, 1, "2021-04-22"),
      new CollectVO(0, 0, 0, 1, "2021-04-15")
    );
    val map    = list.stream().collect(groupingBy(CollectVO::getDate, reducing(new CollectVO(), CollectVO::reduce)));
    val result = copyOf(map.values());
    log.info(result.toString());
  }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class CollectVO {
  int    normal = 0;
  int    major  = 0;
  int    risk   = 0;
  int    check  = 0;
  String date;

  CollectVO reduce(CollectVO vo) {
    return new CollectVO(normal + vo.normal, major + vo.major, risk + vo.risk, check + vo.check, vo.date);
  }
}
