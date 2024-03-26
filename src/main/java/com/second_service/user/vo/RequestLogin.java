package com.second_service.user.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestLogin {
    @NotNull(message = "이메일을 입력해주세요")
    @Size(min = 2, message = "자리수가 부족합니다.")
    @Email
    private String email;

    @NotNull(message = "비밀번호를 입력해주세요")
    @Size(min = 8, message = "자리수가 부족합니다.")
    private String password;
}
