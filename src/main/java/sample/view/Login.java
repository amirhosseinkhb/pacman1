package sample.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.LoginController;
import sample.model.User;
import sample.controller.showCurrentUser;



import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class Login extends Application {
    private static Stage stage;
    @FXML
    private TextField usernameE;
    @FXML
    private PasswordField passwordE;
    @FXML
    private Text error;





    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }



    public void exitClicked(MouseEvent mouseEvent) {
        System.exit(0);
    }


    public void loginClicked(MouseEvent mouseEvent) throws Exception {
        if (LoginController.loginCheck(usernameE.getText(), passwordE.getText())) {
            showCurrentUser.user = User.getUserByName(usernameE.getText());
            new Asli().start(stage);
        } else {
            error.setText("Login Failed");

        }
    }

    public void RegisterClicked(MouseEvent mouseEvent) throws Exception {
        new Register().start(stage);
    }


}
