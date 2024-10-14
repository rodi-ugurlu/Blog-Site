package com.rodiugurlu.starter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum MessageType {
    RECORD_NOT_FOUND("1000","RECORD NOT FOUND"),
    SUCCES("2000","PROCESS SUCCESSFUL"),
    NO_RECORD_EXIST("3000","NO RECOR EXIST"),
    GENERAL_EXCEPTION("4000","GENERAL ERROR OCCURRED");
    private String code;
    private String message;
    private MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
