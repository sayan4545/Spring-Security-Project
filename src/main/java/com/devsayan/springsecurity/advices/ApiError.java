package com.devsayan.springsecurity.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;
@Data
@Builder
public class ApiError {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

//    public ApiError(){
//        this.timestamp = LocalDateTime.now();
//    }
//    public ApiError(String message, HttpStatus httpStatusCode){
//        this();
//        this.message = message;
//        this.status = httpStatusCode;
//    }

}
