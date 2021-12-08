package sample.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.model.User;

import java.util.LinkedList;
import java.util.List;


public class Asli extends Application {
    private static Stage stage;


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("Asli.fxml"));
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

    public void logoutClicked(MouseEvent mouseEvent) throws Exception {
        new Login().start(stage);
    }

    public void settingClicked(MouseEvent mouseEvent) throws Exception {
        new Setting().start(stage);
    }

    public void profileClicked(MouseEvent mouseEvent) throws Exception {
        new Profile().start(stage);
    }

    public void newGameClicked(MouseEvent mouseEvent) throws Exception {
        new Game().start(stage);
    }

    public void scoreboardClicked(MouseEvent mouseEvent) throws Exception{
        new Scoreboard().start(stage);
    }
}
