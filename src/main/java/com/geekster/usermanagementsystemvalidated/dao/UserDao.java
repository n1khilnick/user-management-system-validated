package com.geekster.usermanagementsystemvalidated.dao;

import com.geekster.usermanagementsystemvalidated.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDao {
    private List<User> userList;

    public UserDao(){
        userList = new ArrayList<>();
        userList.add(new User("0","Jhondoe1", LocalDate.now().toString(),"saininikhilnnn@gmail.com","+916477237130", LocalDate.now().toString(), LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"))));
    }

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getAllUser(){
        return userList;
    }

    public boolean removeUserById(User user){
        userList.remove(user);
        return true;
    }

    public boolean updateUser(String userID,String emailID,String phoneNum){
         for(User user : userList){
             if(user.getUserID().equals(userID)){
                 removeUserById(user);
                 user.setEmailID(emailID);
                 user.setPhoneNum(phoneNum);
                 addUser(user);
                 return true;
             }
         }
         return false;
    }


}
