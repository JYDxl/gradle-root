package org.github.web.model.shiro;

import lombok.Data;

import javax.annotation.Nullable;
import java.util.List;

@Data
public class AuthorInfo {
    private @Nullable String roleCode;

    private @Nullable List<String> perms;
}
