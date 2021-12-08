package sample.controller;

public class ChangePasswordController {
    public static boolean isPasswordCorrect(String password){
        return showCurrentUser.user.getPassword().equals(password);
    }

    public static void changePassword(String newPassword){
        showCurrentUser.user.setPassword(newPassword);
    }
}
