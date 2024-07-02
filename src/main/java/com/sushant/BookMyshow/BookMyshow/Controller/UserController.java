package com.sushant.BookMyshow.BookMyshow.Controller;

import com.sushant.BookMyshow.BookMyshow.CoustomResponse.Response;
import com.sushant.BookMyshow.BookMyshow.Entity.User;
import com.sushant.BookMyshow.BookMyshow.Repository.UserRepository;
import com.sushant.BookMyshow.BookMyshow.Service.ServiceImplementation.UserServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registerUser")
public class UserController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @PostMapping("/sign-in")
    public Response<?> signIn(@Valid @RequestBody User signInRequest){
        return userServiceImplementation.addUser(signInRequest);
    }
}