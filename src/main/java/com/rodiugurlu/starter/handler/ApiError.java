package com.rodiugurlu.starter.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError <T>{
    private int status;
    private Exception <T> exception;
}
