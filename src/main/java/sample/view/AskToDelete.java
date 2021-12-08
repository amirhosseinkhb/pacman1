package sample.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.controller.DeleteUserController;
import sample.model.User;
import sample.controller.showCurrentUser;
public class AskToDelete extends Application {
    private static Stage stage2;
    private static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage2=stage;
        Stage stage1=new Stage();
        stage=stage1;
        Parent parent = FXMLLoader.load(getClass().getResource("AskToDelete.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void delete(MouseEvent mouseEvent) throws Exception {
        new DeleteUser().delete(showCurrentUser.usernameFoeDeleteing);
        if (showCurrentUser.usernameFoeDeleteing.equals(showCurrentUser.user.getUsername())){
            stage2.close();
            new Login().start(stage2);
        }else
        new Profile().start(stage2);
    }


    public void cancel(MouseEvent mouseEvent) throws Exception {
        stage2.close();
        new DeleteUser().start(stage2);
    }

}
