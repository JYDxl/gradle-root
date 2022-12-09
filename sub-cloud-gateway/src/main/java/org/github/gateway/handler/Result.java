package org.github.gateway.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import static cn.hutool.core.text.CharSequenceUtil.firstNonBlank;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private int code = OK.value();

    @NonNull
    private String msg = OK.name();

    public static Result of(HttpStatus status, String msg) {
        return new Result(status.value(), firstNonBlank(msg, status.name()));
    }
}
