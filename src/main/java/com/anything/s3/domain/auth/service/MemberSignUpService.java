package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.exception.DuplicatedEmailException;
import com.anything.s3.domain.auth.presentation.dto.request.SignUpRequest;
import com.anything.s3.domain.email.entity.Email;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.repository.MemberRepository;
import com.anything.s3.global.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

     private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
     private final EmailUtil emailUtil;

     public void execute(SignUpRequest request) {
         if (memberRepository.existsByEmail(request.getEmail())) {
             throw new DuplicatedEmailException();
         }

         Email emailAuth = emailUtil.getEmailEntityById(request.getEmail());

         emailUtil.checkEmailAuthentication(emailAuth);

         Member member = Member.builder()
                 .email(request.getEmail())
                 .name(request.getName())
                 .password(passwordEncoder.encode(request.getPassword()))
                 .role(request.getRole())
                 .build();

         memberRepository.save(member);
     }
}
