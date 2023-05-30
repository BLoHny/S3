package com.anything.s3.domain.member.exception;

import com.anything.s3.global.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class ChangePasswordMismatchException extends RuntimeException{

    public ChangePasswordMismatchException() {
        super(String.valueOf(ErrorCode.MISMATCH_PASSWORD));
    }
}
