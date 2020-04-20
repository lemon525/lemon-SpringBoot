package com.lemon.springboot.exception;

import com.lemon.springboot.dto.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result exception(MethodArgumentNotValidException e) {
        return Result.isFailure(500,null,e.getBindingResult().getFieldError().getDefaultMessage());
    }

}
