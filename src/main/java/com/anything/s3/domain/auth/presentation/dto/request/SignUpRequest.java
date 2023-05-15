package com.anything.s3.domain.auth.presentation.dto.request;

import com.anything.s3.domain.member.entity.enums.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpRequest {

    @Email
    @NotBlank(message = "이메일은 필수 입력값입니다")
    @Column(unique = true)
    private final String email;
    @NotBlank(message = "이름은 필수 입력값입니다")
    private final String name;
    @NotBlank(message = "비밀번호는 필수 입력값입니다")
    private final String password;
    private final Role role;
}