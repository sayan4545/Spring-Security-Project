package com.devsayan.springsecurity.advices;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
@Data
public class ApiError {

    private LocalDateTime timestamp;
    private HttpStatusCode httpStatusCode;
    private String error;

    public ApiError(){
        this.timestamp = LocalDateTime.now();
    }
    public ApiError(String error, HttpStatusCode httpStatusCode){
        this();
        this.error = error;
        this.httpStatusCode = httpStatusCode;
    }

}
