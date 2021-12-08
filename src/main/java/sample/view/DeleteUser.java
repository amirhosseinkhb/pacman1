package sample.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.DeleteUserController;
import sample.controller.LoginController;
import sample.controller.RegisterController;
import sample.model.User;
import sample.controller.showCurrentUser;

import java.io.IOException;

public class DeleteUser extends Application {
    private static Stage stage;
    @FXML
    private TextField usernameE;
    @FXML
    private PasswordField passwordE;
    @FXML
    private Text error;
    @FXML
    private Button btnDelete;
    @FXML
    private Label text;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("DeleteUser.fxml"));
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
        new Profile().start(stage);
    }

    public void deleteUserClicked(MouseEvent mouseEvent) throws Exception {
        if (User.usernameExist(usernameE.getText())) {
            if (LoginController.loginCheck(usernameE.getText(), passwordE.getText())) {
                showCurrentUser.usernameFoeDeleteing = usernameE.getText();
                new AskToDelete().start(stage);
            } else {
                error.setText("username or password is not correct");
            }
        } else error.setText("username or password is not correct");
    }

    public void delete(String username) {
        DeleteUserController.Delete(User.getUserByName(username));
    }

}
