package com.rodiugurlu.starter.exception;

import com.rodiugurlu.starter.exception.ErrorMessage;

import lombok.Data;


@Data
public class BaseException extends RuntimeException {
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
