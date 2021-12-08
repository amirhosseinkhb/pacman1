package sample.controller;

import sample.model.User;

public class LoginController {

    public static boolean loginCheck(String username,String password){
        if (User.usernameExist(username)){
            User user=User.getUserByName(username);
            if (user.getPassword().equals(password)){
                return true;
            }else {
                return false;
            }
        }else return false;
    }
}
