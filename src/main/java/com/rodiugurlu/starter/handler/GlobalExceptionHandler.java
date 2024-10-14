package com.rodiugurlu.starter.handler;

import com.rodiugurlu.starter.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler <T>{
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError> handleBaseException(BaseException ex, WebRequest request){
        return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));

    }

    private String getHostname(){
        try {
            return InetAddress.getLocalHost().getHostName();
        }catch (UnknownHostException e) {
            System.out.println("hata oluştu"+e.getMessage());
        }
        return null;
    }


    public <T> ApiError <T> createApiError(T data, WebRequest request){
    ApiError <T> apiError = new ApiError<>();
    apiError.setStatus(HttpStatus.BAD_REQUEST.value());
    Exception<T> exception = new Exception<>();
    exception.setTime(new Date());
    exception.setHostName(exception.getHostName());
    exception.setPath(request.getDescription(false));
    exception.setData(data);
    apiError.setException(exception);
    return apiError;
}

}
