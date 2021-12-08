package sample.controller;

import sample.model.User;

public class DeleteUserController {
    public static void Delete(User user) {
    User.allUsers.remove(user);
    }
}
