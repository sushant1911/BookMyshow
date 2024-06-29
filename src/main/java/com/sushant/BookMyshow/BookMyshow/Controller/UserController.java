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
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public Response<List<User>> getAllUser()
    {
        return new Response<List<User>>( HttpStatus.OK,"user get All",userRepository.findAll());
    }
    @PostMapping("/saveUser")
    public Response<?> saveUser(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return userServiceImplementation.addUser(user, result);
        }
        return userServiceImplementation.addUser(user, result);
    }
}
