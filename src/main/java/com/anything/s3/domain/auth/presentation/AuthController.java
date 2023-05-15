package com.anything.s3.domain.auth.presentation;

import com.anything.s3.domain.auth.presentation.dto.request.SignUpRequest;
import com.anything.s3.domain.auth.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

        private final MemberSignUpService signUpService;

        @GetMapping
        public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
            signUpService.execute(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
}
