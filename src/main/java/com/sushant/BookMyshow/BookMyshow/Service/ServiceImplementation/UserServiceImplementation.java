package com.sushant.BookMyshow.BookMyshow.Service.ServiceImplementation;

import com.sushant.BookMyshow.BookMyshow.CoustomResponse.Response;
import com.sushant.BookMyshow.BookMyshow.Entity.User;
import com.sushant.BookMyshow.BookMyshow.Repository.UserRepository;
import com.sushant.BookMyshow.BookMyshow.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Response<?> addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return new Response<>(HttpStatus.BAD_REQUEST, "Validation Error", new ErrorResponse<>(HttpStatus.BAD_REQUEST, "Validation failed", errors));
        }
        return new Response<>(HttpStatus.OK, "User added successfully", userRepository.save(user));
    }


}
