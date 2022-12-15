package org.github.core.util.tree;

import java.util.Collection;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;

@Data
public class DefaultTreeNode<I, E> implements TreeNode<I, E> {
    @Nullable
    private I pid;
    @NonNull
    private I id;
    @NonNull
    private String name;
    @Nullable
    private E extra;
    @Nullable
    private Collection<? extends TreeNode<I, E>> child;

    public DefaultTreeNode(@Nullable I pid, @NonNull I id, @NonNull String name) {
        this.pid = pid;
        this.id = id;
        this.name = name;
    }
}
