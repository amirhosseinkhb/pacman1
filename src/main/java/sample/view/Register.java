package sample.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.RegisterController;
import sample.model.User;



public class Register extends Application {
    private static Stage stage;
    @FXML
    private TextField usernameRegister;
    @FXML
    private PasswordField passwordRegister;
    @FXML
    private PasswordField passwordCheck;
    @FXML
    Text error;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }


    public void registerClicked(MouseEvent mouseEvent) throws Exception {
        if (!User.usernameExist(usernameRegister.getText())) {
            if (RegisterController.arePasswordEqual(passwordRegister.getText(), passwordCheck.getText())) {
                RegisterController.register(usernameRegister.getText(), passwordRegister.getText());
                new Login().start(stage);
            } else {
                error.setText("passwords did not match");
            }
        } else {
            error.setText("username already exists");
        }
    }

    public void exitClicked(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void backClicked(MouseEvent mouseEvent) throws Exception {
        new Login().start(stage);
    }
}
