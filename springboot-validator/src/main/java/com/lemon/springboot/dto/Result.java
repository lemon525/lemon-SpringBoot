package com.lemon.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result isSuccess(Integer code, T obj, String message) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(code);
        result.setData(obj);
        result.setMessage(message);
        return result;
    }

    public static <T> Result isFailure(Integer code, T obj, String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setData(obj);
        result.setMessage(message);
        return result;
    }
}
