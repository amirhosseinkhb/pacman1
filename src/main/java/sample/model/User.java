package sample.model;


import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    public int score=0;
    public static ArrayList<User> allUsers=new ArrayList<>();


    public User(String username,String password){
        setUsername(username);
        setPassword(password);
        allUsers.add(this);
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public static boolean usernameExist(String username){
        boolean check=false;
        for (User user:allUsers){
            if (user.username.equals(username)){
                check=true;
                break;
            }
        }
        return check;
    }
    public static User getUserByName(String username){
        User answer=null;
        for (User user:User.allUsers){
            if (user.username.equals(username)){
                answer=user;
                break;
            }
        }
        return answer;
    }
}
