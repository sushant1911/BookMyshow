package com.sushant.BookMyshow.BookMyshow.Service.ServiceImplementation;

import com.sushant.BookMyshow.BookMyshow.CoustomResponse.Response;
import com.sushant.BookMyshow.BookMyshow.Entity.User;
import com.sushant.BookMyshow.BookMyshow.Repository.UserRepository;
import com.sushant.BookMyshow.BookMyshow.Service.UserService;
import com.sushant.BookMyshow.BookMyshow.utills.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response<?> addUser(User user) {
        logger.info("addUser Method called");
        User newUser = new User();
        newUser.setUserFirstName(user.getUserFirstName());
        newUser.setUserMiddleName(user.getUserMiddleName());
        newUser.setUserLastName(user.getUserLastName());
        newUser.setEmail(user.getEmail());
        newUser.setMobileNumber(user.getMobileNumber());
        newUser.setBirthday(user.getBirthday());
        newUser.setRole(user.getRole() == null ? "user" : user.getRole());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.info("user creation done : userDetail", Mapper.mapToJsonString(newUser));
        return new Response<>(HttpStatus.OK, "User added successfully", userRepository.save(newUser));
    }


}
