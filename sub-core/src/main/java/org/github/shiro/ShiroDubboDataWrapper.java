package org.github.shiro;

import lombok.Data;

@Data
public class ShiroDubboDataWrapper<T> {
    private String token;

    private String jwt;

    private T data;
}
