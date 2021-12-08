package sample.controller;

import sample.model.User;

public class RegisterController {


    public static boolean arePasswordEqual(String password,String passwordCheck){
        return password.equals(passwordCheck);
    }

    public static void register(String username,String password){
        new User(username, password);
    }
}


