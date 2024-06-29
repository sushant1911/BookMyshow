package com.sushant.BookMyshow.BookMyshow.ExceptionHandler;

import com.sushant.BookMyshow.BookMyshow.CoustomResponse.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new Response<>(HttpStatus.BAD_REQUEST, "Validation Error", new ErrorResponse<>(HttpStatus.BAD_REQUEST, "Validation failed", errors));
    }
}