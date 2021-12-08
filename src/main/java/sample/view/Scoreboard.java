package sample.view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.controller.ScoreboardController;
import sample.model.User;

public class Scoreboard extends Application {
    private static Stage stage;

    @FXML
    private Text best;
    @FXML
    private Text rest;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        Parent parent = FXMLLoader.load(getClass().getResource("Scoreboard.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        ScoreboardController.sort();
        best.setText(User.allUsers.get(0).getUsername()+": "+User.allUsers.get(0).score);
        String ranking = "";
        int i = 2,j=1;
        while (i <= 11) {
            if (j>=User.allUsers.size()){
                break;
            }
            ranking += i + ". " + User.allUsers.get(j).getUsername() +": "+User.allUsers.get(j).score+ "\n";
            if (User.allUsers.get(j).score!=User.allUsers.get(j-1).score){
                i++;
            }
            j++;
        }
        rest.setText(ranking);
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


}
