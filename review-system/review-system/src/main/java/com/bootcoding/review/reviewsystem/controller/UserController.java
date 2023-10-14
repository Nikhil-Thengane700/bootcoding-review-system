package com.bootcoding.review.reviewsystem.controller;

import com.bootcoding.review.reviewsystem.model.User;
import com.bootcoding.review.reviewsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
UserService userService;
    @GetMapping("/health/check")
    public String healthCheckup(){
        return "I am alive";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user ){
        return userService.createUser(user);
    }
    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userid}")
    public User getStudent(@PathVariable int userid) {

            return   userService.getUser(userid);}

    @DeleteMapping("/user/{userid}")
    public int deleteUserById(@PathVariable int id) {
        return userService.deleteUserByUserId(id);
    }

        @PutMapping("/user/{userid}")
        public int updateUserById(@RequestBody User user,@PathVariable("userid") int id) {

        return userService.updateUserById(user,id);



        }


    }






