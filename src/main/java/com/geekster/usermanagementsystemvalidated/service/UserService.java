package com.geekster.usermanagementsystemvalidated.service;

import com.geekster.usermanagementsystemvalidated.dao.UserDao;
import com.geekster.usermanagementsystemvalidated.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void addUser(User user){
        userDao.addUser(user);
    }

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

    public User getUserByID(String userID){
        if(userID != null){
            List<User> allUserList = getAllUser();
            for(User user :allUserList){
                if(user.getUserID().equals(userID)){
                    return user;
                }
            }

        }
        return null;
    }

    public String deleteUserById(String userID){
        if(userID == null){
            return "Error !! ID cannot be null !";
        } else {
            List<User> allUsers = userDao.getAllUser();
             for(User user :allUsers){
                 if(user.getUserID().equals(userID)){
                    boolean isDeleted = userDao.removeUserById(user);
                     if(isDeleted) return "User with ID "+userID+" was removed successfully.";
                     else return "Failed ! Unable to remove user !!";
                 }
             }
             return  "Couldn't find User with ID="+userID+" ! Please try again !.";
        }
    }

    public String updateUser(String userID,String emailID, String phoneNum){
        boolean isDeleted = userDao.updateUser(userID,emailID,phoneNum);

        if(userID == null){
            return "Error !! id  cannot be null !";
        }
        else if(isDeleted){
            return  "User with id "+userID+" updated.";
        }
        return "Unable to update user with id "+userID +" id doesn't exists !";
    }
}
