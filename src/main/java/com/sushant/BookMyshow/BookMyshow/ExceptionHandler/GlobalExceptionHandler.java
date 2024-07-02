package com.sushant.BookMyshow.BookMyshow.ExceptionHandler;

import com.sushant.BookMyshow.BookMyshow.CoustomResponse.Response;
import com.sushant.BookMyshow.BookMyshow.utills.Mapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.HttpRequestMethodNotSupportedException;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        logger.error("MethodArgumentNotValidException.class" , Mapper.mapToJsonString(errors));
        return new Response<>(HttpStatus.BAD_REQUEST, "Validation Error", errors);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<Object> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        logger.error("NotFoundException.class" + ex.getMessage());
        return new Response<>(HttpStatus.NOT_FOUND, "NotFoundException", ex.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Response<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        logger.error("HttpRequestMethodNotSupportedException.class" , Mapper.mapToJsonString(ex.getMessage()));
        return new Response<>(HttpStatus.METHOD_NOT_ALLOWED, "Method Not Allowed", ex.getBody().getDetail());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> handleBadRequestException(BadRequestException ex) {
        logger.error("BadRequestException.class" + ex.getMessage());
        return new Response<>(HttpStatus.BAD_REQUEST, "BadRequestException", ex.getMessage());
    }
}