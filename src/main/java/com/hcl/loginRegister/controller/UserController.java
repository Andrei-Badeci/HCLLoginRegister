package com.hcl.loginRegister.controller;

import com.hcl.loginRegister.model.User;
import com.hcl.loginRegister.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login")
    public ResponseEntity<User> findUserByEmailAndPassword(@RequestBody User user){
        LOGGER.info(String.format("Finding user with email %s and password %s", user.getEmail(), user.getPassword()));
        User foundUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (foundUser != null) {
            return new ResponseEntity<User>(foundUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/user/register")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        LOGGER.info(String.format("Adding user with first name %s, last name %s, username %s, " +
                "email %s and password %s", user.getFirstName(), user.getLastName(), user.getUsername(),
                user.getEmail(), user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
