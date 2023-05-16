package com.anything.s3.domain.auth.presentation;

import com.anything.s3.domain.auth.presentation.dto.request.SignInRequest;
import com.anything.s3.domain.auth.presentation.dto.request.SignUpRequest;
import com.anything.s3.domain.auth.presentation.dto.response.SignInResponse;
import com.anything.s3.domain.auth.service.MemberLoginService;
import com.anything.s3.domain.auth.service.MemberSignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

        private final MemberSignUpService signUpService;
        private final MemberLoginService loginService;

        @GetMapping("/signup")
        public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request) {
            signUpService.execute(request);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @PostMapping("/login")
        public ResponseEntity<SignInResponse> login(@Valid @RequestBody SignInRequest request) {
            SignInResponse response = loginService.execute(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
}
