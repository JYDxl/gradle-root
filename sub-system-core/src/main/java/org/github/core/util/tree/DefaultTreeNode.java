package org.github.core.util.tree;

import java.util.Collection;
import org.jetbrains.annotations.Nullable;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class DefaultTreeNode<I, E> implements TreeNode<I, E> {
    @Nullable
    private I pid;
    @NotNull
    private I id;
    @NotNull
    private String name;
    @Nullable
    private E extra;
    @Nullable
    private Collection<? extends TreeNode<I, E>> child;

    public DefaultTreeNode(@Nullable I pid, @NotNull I id, @NotNull String name) {
        this.pid = pid;
        this.id = id;
        this.name = name;
    }
}
