package com.userservice.userservice.user.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUser {
    @NotNull(message = "이메일을 입력해주세요.")
    @Size(min = 2, message = "이메일은 2글자 이상 가능합니다.")
    @Email
    private String email;

    @NotNull(message = "이름을 입력해주세요.")
    @Size(min = 2, message = "이름은 2글자 이상 가능합니다.")
    private String name;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 8글자 이상 가능합니다.")
    private String pwd;
}
