package org.github.util.tree;

import java.util.List;
import lombok.*;
import lombok.extern.slf4j.*;
import org.github.mysql.web.base.entity.TabSafeQuestionDataEntity;
import org.github.mysql.web.base.entity.TabSafeQuestionTypeEntity;
import org.github.mysql.web.base.service.ITabSafeQuestionDataService;
import org.github.mysql.web.base.service.ITabSafeQuestionTypeService;
import org.github.web.model.vo.TreeVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static com.google.common.base.MoreObjects.*;
import static com.google.common.collect.ImmutableList.copyOf;
import static com.google.common.collect.ImmutableList.*;
import static com.google.common.collect.ImmutableListMultimap.*;
import static com.google.common.collect.Lists.*;
import static java.util.Comparator.*;
import static java.util.Objects.*;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Stream.*;
import static org.github.spring.ops.SpringsKt.*;
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
    val vo = new TreeVO(firstNonNull(data.getQuestionTypeId(), ""), requireNonNull(data.getId()), requireNonNull(data.getCheckContent()));
    vo.setLeaf(true);
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

    val tree = buildTree(list, "", nullsFirst(comparing(TreeVO::getName)));
    val json = json(tree);
    log.info(json);
  }

  @Test
  void findAllChildTest() {
    val query = safeQuestionTypeService.lambdaQuery();
    query.eq(TabSafeQuestionTypeEntity::getProjectId, "-1");
    val data  = query.list();
    val list  = data.stream().map(this::applyTabSafeQuestionTypeEntity2TreeVO).collect(toList());
    val index = list.stream().collect(toImmutableListMultimap(TreeNode::getPid, identity()));
    val root  = index.get("");
    val ids   = root.stream().map(TreeVO::getId).collect(toImmutableList());
    val child = findAllChild(list, true, ids);
    log.info(json(child));
  }

  @NonNull TreeVO applyTabSafeQuestionTypeEntity2TreeVO(@NonNull TabSafeQuestionTypeEntity type) {
    val vo = new TreeVO(firstNonNull(type.getParentId(), ""), requireNonNull(type.getId()), requireNonNull(type.getTypeName()));
    vo.setLeaf(false);
    return vo;
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
