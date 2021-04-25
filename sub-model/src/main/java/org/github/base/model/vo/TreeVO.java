package org.github.base.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import org.github.util.tree.TreeNode;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class TreeVO extends TreeNode<String, Object> {
    private boolean leaf;

    public TreeVO(@NonNull String pid, @NonNull String id, @NonNull String name) {
        super(pid, id, name);
    }
}
