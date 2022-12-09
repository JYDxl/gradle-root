package org.github.core.props;

import lombok.Data;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Data
public class DynamicProperties {
    private List<String> whiteList = newArrayList();
}
