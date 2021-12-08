package sample.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.RegisterController;
import sample.controller.ChangePasswordController;

public class ChangePassword extends Application {
    private static Stage stage;
    @FXML
    private PasswordField currentPassword;
    @FXML
    private PasswordField newpass;
    @FXML
    private PasswordField passCheck;
    @FXML
    private Text error;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
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

    public void changeClicked(MouseEvent mouseEvent) {
        if (ChangePasswordController.isPasswordCorrect(currentPassword.getText())) {
            if (RegisterController.arePasswordEqual(newpass.getText(), passCheck.getText())) {
                if (!RegisterController.arePasswordEqual(newpass.getText(), currentPassword.getText())) {
                    ChangePasswordController.changePassword(newpass.getText());
                    error.setText("password changed");
                } else {
                    error.setText("new password and current password are same");
                }
            } else {
                error.setText("new password and password checker are not equal");
            }
        } else {
            error.setText("current password is not correct");
        }
    }

}
