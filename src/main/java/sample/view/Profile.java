package sample.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.showCurrentUser;

public class Profile extends Application {
    private static Stage stage;
    @FXML
    private Text score;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void exitClicked(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void backClicked(MouseEvent mouseEvent) throws Exception {
        new Asli().start(stage);
    }

    public void changePasswordClicked(MouseEvent mouseEvent) throws Exception {
        new ChangePassword().start(stage);
    }

    public void deleteUserClicked(MouseEvent mouseEvent) throws Exception {
        new DeleteUser().start(stage);
    }

    public void showScoreClicked(MouseEvent mouseEvent){
        score.setText("your score is : "+ showCurrentUser.user.score);
    }


}
