package com.rodiugurlu.starter.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exception <T>{
    private String hostName;
    private int path;
    private Date time;
    private T data;
    public void setPath(String desc){}
}
