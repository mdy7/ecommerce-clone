package com.nocaffeine.ssgclone.common.exception;


import com.nocaffeine.ssgclone.common.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BaseException.class)
    public CommonResponse<?> baseException(BaseException e) {
        return CommonResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> exception(Exception e) {
        return CommonResponse.fail(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }

}
