package com.anything.s3.domain.email.presentation.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailSendRequest {

    @Id
    @NotBlank(message = "이메일은 필수 입력값임")
    private String email;
}
