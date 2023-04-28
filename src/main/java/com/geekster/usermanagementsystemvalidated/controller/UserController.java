package com.geekster.usermanagementsystemvalidated.controller;
import com.geekster.usermanagementsystemvalidated.model.User;
import com.geekster.usermanagementsystemvalidated.service.UserService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/addUser")
    public String addUser(@Valid @RequestBody User user){
        userService.addUser(user);
        System.out.println(user.getDob());
        return "User Added !";
    }

    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(value = "getUser/{userID}")
    public User getUserByID(@Nullable @PathVariable String  userID ){
        return userService.getUserByID(userID);
    }

    @DeleteMapping(value = "/deleteUser/{userID}")
    public String deleteUserById(@PathVariable String userID){
        return userService.deleteUserById(userID);
    }

    @PutMapping(value ="/updateUserInfo/{userID}/{emailID}/{phoneNum}")
    public String updateUser(@PathVariable String userID, @PathVariable String emailID, @PathVariable String phoneNum){
        return userService.updateUser(userID,emailID,phoneNum);
    }


}
