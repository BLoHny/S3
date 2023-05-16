package com.anything.s3.domain.auth.service;

import com.anything.s3.domain.auth.entity.RefreshToken;
import com.anything.s3.domain.auth.presentation.dto.request.SignInRequest;
import com.anything.s3.domain.auth.presentation.dto.response.SignInResponse;
import com.anything.s3.domain.auth.repository.RefreshTokenRepository;
import com.anything.s3.domain.member.entity.Member;
import com.anything.s3.domain.member.repository.MemberRepository;
import com.anything.s3.global.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional(rollbackFor = Exception.class)
    public SignInResponse execute(SignInRequest request) {

        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("이메일이 없음"));

        if(!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new RuntimeException("패스워드가 일치하지 않음");
        }

        String accessToken = tokenProvider.generatedAccessToken(request.getEmail());
        String refreshToken = tokenProvider.generatedRefreshToken(request.getEmail());
        RefreshToken tokenRedis = new RefreshToken(request.getEmail(), refreshToken, tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());

        refreshTokenRepository.save(tokenRedis);

        return SignInResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(tokenProvider.getExpiredAtToken())
                .build();
    }
}
