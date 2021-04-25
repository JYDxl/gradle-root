package org.github.base.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TreeVO<T> {
    private String pid;

    private String id;

    private String name;

    private boolean leaf;

    private T extra;

    private List<TreeVO<T>> child;
}
