package com.sushant.BookMyshow.BookMyshow.CoustomResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Response<T> {
    private HttpStatus status;
    private String message;
    private T data;
}
