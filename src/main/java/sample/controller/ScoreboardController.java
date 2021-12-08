package sample.controller;

import sample.model.User;

import java.util.UUID;

public class ScoreboardController {

    public static void sort() {
        for (int i = 1; i < User.allUsers.size(); ++i) {
            User key = User.allUsers.get(i);
            int j = i - 1;
            while (j >= 0 && User.allUsers.get(j).score < key.score) {
                User.allUsers.set(j + 1, User.allUsers.get(j));
                j = j - 1;
            }
            User.allUsers.set(j + 1, key);
        }

        for (int i = 1; i < User.allUsers.size(); ++i) {
            User key = User.allUsers.get(i);
            int j = i - 1;
            while (j >= 0 && User.allUsers.get(j).score == key.score && key.getUsername().compareTo(User.allUsers.get(j).getUsername()) <= 1) {

                User.allUsers.set(j + 1, User.allUsers.get(j));
                j = j - 1;
            }
            User.allUsers.set(j + 1, key);
        }
    }
}

