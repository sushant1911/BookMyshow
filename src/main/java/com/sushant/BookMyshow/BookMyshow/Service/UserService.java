package com.sushant.BookMyshow.BookMyshow.Service;

import com.sushant.BookMyshow.BookMyshow.CoustomResponse.Response;
import com.sushant.BookMyshow.BookMyshow.Entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface UserService {
    public Response<?> addUser(@Valid User user);
}
