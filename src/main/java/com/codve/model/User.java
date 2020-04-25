package com.codve.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 64, message = "用户名长度为 2 ~ 64 个字符")
    private String name;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 32, message = "密码长度为 6 ~ 32 个字符")
    private String password;

    @Min(value = 1)
    private Long createTime;

    @Min(value = 1)
    private Long updateTime;
}
