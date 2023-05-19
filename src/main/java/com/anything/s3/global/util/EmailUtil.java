package com.anything.s3.global.util;

import com.anything.s3.domain.email.entity.Email;
import com.anything.s3.domain.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailUtil {

    private final EmailRepository emailRepository;

    public Email getEmail(String email) {
        return emailRepository.findById(email)
                .orElseThrow(() -> new RuntimeException("유효 하지 않은 이메일"));
    }

    public void checkEmailAuthentication(Email emailAuth) {
        if(!emailAuth.getAuthentication()) {
            throw new RuntimeException("유효 하지 않은 이메일");
        }
    }
}