package sample.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.LoginController;
import sample.view.Asli;
import sample.view.Register;

public class viewController extends Application {
    private static Stage stage;
    @FXML private TextField usernameE;
    @FXML private PasswordField passwordE;
    @FXML private Text error;

    private Media media = new Media(String.valueOf((getClass().getResource("music/menu.mp3"))));
    public MediaPlayer mediaPlayer = new MediaPlayer(media);

    @Override
    public void start(Stage stage) throws Exception {
        mediaPlayer.setAutoPlay(true);
        this.stage=stage;
        Parent parent = FXMLLoader.load(getClass().getResource("startPage.fxml"));
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


    public void loginClicked(MouseEvent mouseEvent) throws Exception {
        if (LoginController.loginCheck(usernameE.getText(),passwordE.getText())){
            new Asli().start(stage);
        }else {
            error.setText("Login Failed");
        }
    }

    public void RegisterClicked(MouseEvent mouseEvent) throws Exception {
        new Register().start(stage);
    }
}
