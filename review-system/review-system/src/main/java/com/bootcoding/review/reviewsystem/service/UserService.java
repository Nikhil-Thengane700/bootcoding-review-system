package com.bootcoding.review.reviewsystem.service;

import com.bootcoding.review.reviewsystem.model.User;
import com.bootcoding.review.reviewsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userrepository;
    public String createUser(User user) {
        print(user);
        userrepository.save( user);

        return "SUCCESSFULLY USER CREATED";
    }

    private void print(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getEmailId());
        System.out.println(user.getPhonno());


    }


    public List<User> getAllUsers(){
        return userrepository.getAllUsers();
    }

    public User getUser(int userid) {
        return userrepository.getUserById(userid);
    }

    public int deleteUserByUserId(int userId){
        return userrepository.deleteUserById(userId);
    }
    public int updateUserById(User user,int id) {
        return userrepository.updateUserById(user,id);
    }
}
