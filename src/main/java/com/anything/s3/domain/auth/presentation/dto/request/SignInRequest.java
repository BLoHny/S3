package com.anything.s3.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignInRequest {
    @Email
    @NotBlank(message = "이메일은 필수 입력값입니다")
    private final String email;
    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    private final String password;

}