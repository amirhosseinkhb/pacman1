package sample.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.controller.showCurrentUser;


import java.io.IOException;
import java.util.ArrayList;

public class Game extends Application {

    @FXML
    private Text score;
    @FXML
    private Rectangle pacman;
    @FXML
    private ImageView jon1;
    @FXML
    private ImageView jon2;
    @FXML
    private ImageView jon3;

    private int[][] walls = new int[30][20];
    private ImagePattern pacmanRight = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/pacmanRight.gif")))));
    private ImagePattern pacmanLeft = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/pacmanLeft.gif")))));
    private ImagePattern pacmanUp = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/pacmanUp.gif")))));
    private ImagePattern pacmanDown = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/pacmanDown.gif")))));
    private ImagePattern ghost1Image = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/ghost1.gif")))));
    private ImagePattern ghost2Image = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/ghost2.gif")))));
    private ImagePattern ghost3Image = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/ghost3.gif")))));
    private ImagePattern ghost4Image = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/ghost4.gif")))));


    private int liveScore = 0;
    private int jon = 3;
    private int req_dy;
    private int req_dx;
    private int blockSize = 20;
    private static Stage stage;
    private static AnchorPane anchorPane;
    private Timeline timer;
    private Timeline timerGhost;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        this.anchorPane=anchorPane;
        anchorPane.getChildren().addAll(drawMap());
        anchorPane.getChildren().addAll(drawPoints(anchorPane));
        anchorPane.getChildren().addAll(creatGhost());
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }


    public ArrayList<Ghost> creatGhost() {
        int i = 0;
        for (Ghost ghost : Ghost.getAllGhosts()) {
            i++;
        }
        if (i >= 4) {
            return Ghost.getAllGhosts();
        }
        new Ghost(580, 0, ghost1Image);
        new Ghost(580, 360, ghost2Image);
        new Ghost(0, 360, ghost3Image);
        new Ghost(0, 0, ghost4Image);

        return Ghost.getAllGhosts();
    }

    public ArrayList<wall> drawMap() {

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                walls[i][j] = 0;
            }
        }


        drawWall(2, 1);
        drawWall(3, 1);
        drawWall(4, 1);
        drawWall(4, 2);
        drawWall(4, 3);
        drawWall(2, 2);
        drawWall(2, 3);

        drawWall(1, 7);
        drawWall(2, 7);
        drawWall(3, 7);
        drawWall(3, 8);
        drawWall(3, 9);
        drawWall(3, 10);
        drawWall(4, 10);
        drawWall(5, 10);
        drawWall(6, 10);
        drawWall(7, 10);
        drawWall(8, 10);
        drawWall(8, 11);

        drawWall(10, 3);
        drawWall(10, 4);
        drawWall(10, 5);
        drawWall(11, 5);



        drawWall(18, 15);
        drawWall(19, 15);
        drawWall(20, 15);
        drawWall(21, 15);
        drawWall(22, 15);
        drawWall(22, 14);
        drawWall(22, 13);
        drawWall(22, 12);
        drawWall(22, 11);
        drawWall(22, 10);
        drawWall(22, 9);

        drawWall(10, 7);
        drawWall(11, 7);

        drawWall(28, 3);
        drawWall(27, 3);
        drawWall(28, 4);

        drawWall(15,5);
        drawWall(15,4);
        drawWall(16,5);
        drawWall(17,5);
        drawWall(18,5);
        drawWall(19,5);
        drawWall(20,5);
        drawWall(21,5);
        drawWall(22,4);
        drawWall(22,5);

        drawWall(3,17);
        drawWall(4,17);
        drawWall(5,17);
        drawWall(6,17);
        drawWall(3,16);
        drawWall(3,15);
        drawWall(3,14);
        drawWall(3,13);

        drawWall(14,14);
        drawWall(14,13);
        drawWall(14,12);
        drawWall(14,11);
        drawWall(14,10);
        drawWall(13,10);
        drawWall(12,10);
        drawWall(11,10);
        drawWall(11,9);
        drawWall(11,8);
        drawWall(11,7);

        drawWall(18,11);
        drawWall(19,11);
        drawWall(20,11);
        drawWall(21,11);
        drawWall(22,11);
        drawWall(23,11);
        drawWall(24,11);
        drawWall(25,11);
        drawWall(25,10);
        drawWall(25,9);
        drawWall(25,8);
        drawWall(25,7);

        return wall.getAllWalls();
    }

    private void drawWall(int x, int y) {
        new wall(x, y);
        walls[x][y] = 1;
    }


    private ArrayList<Point> drawPoints(AnchorPane anchorPane) {


        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 19; j++) {
                if (walls[i][j] == 0) {
                    new Point(i * blockSize, j * blockSize, anchorPane);
                }
            }
        }
        return Point.getAllPoints();
    }

    private void restart() {
        req_dx = 0;
        req_dy = 0;
        pacman.setX(15 * blockSize);
        pacman.setY(15 * blockSize);
        for (Ghost ghost : Ghost.getAllGhosts()) {
            ghost.setX(ghost.getX1());
            ghost.setY(ghost.getY1());
        }
    }
    private void rest(){
        restart();

        Point.getAllPoints().clear();


        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                walls[i][j] = 0;
            }
        }
        drawMap();
        anchorPane.getChildren().addAll(drawPoints(anchorPane));

    }

    private void endGame() throws Exception {
        restart();
        Point.getAllPoints().clear();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                walls[i][j] = 0;
            }
        }

        if (showCurrentUser.user.score < this.liveScore) {
            showCurrentUser.user.score = liveScore;
        }


    }

    public void initialize() {

        drawMap();

        pacman.requestFocus();
        pacman.setX(15 * blockSize);
        pacman.setY(15 * blockSize);
        pacman.setFill(pacmanRight);


        pacman.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                String keyName = keyEvent.getCode().toString();
                if (keyName.equals("LEFT")) {
                    if (pacman.getX() > 0 && walls[((int) pacman.getX() - blockSize) / blockSize][(int) pacman.getY() / blockSize] != 1) {
                        req_dx = -1;
                        req_dy = 0;
                    }
                } else if (keyName.equals("RIGHT")) {
                    if (pacman.getX() <= 560 && walls[((int) pacman.getX() + blockSize) / blockSize][(int) pacman.getY() / blockSize] != 1) {
                        req_dx = 1;
                        req_dy = 0;
                    }
                } else if (keyName.equals("UP")) {
                    if (pacman.getY() > 0 && walls[((int) pacman.getX()) / blockSize][((int) pacman.getY() - blockSize) / blockSize] != 1) {
                        req_dy = -1;
                        req_dx = 0;
                    }
                } else if (keyName.equals("DOWN")) {
                    if (pacman.getY() <= 340 && walls[((int) pacman.getX()) / blockSize][((int) pacman.getY() + blockSize) / blockSize] != 1) {
                        req_dy = 1;
                        req_dx = 0;
                    }
                } else if (keyName.equals("ESCAPE")) {
                    timer.stop();
                    timerGhost.stop();
                    Point.getAllPoints().clear();
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 20; j++) {
                            walls[i][j] = 0;
                        }
                        restart();
                    }
                    try {
                        new Asli().start(stage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //pacman move:
        KeyFrame frame = new KeyFrame(Duration.seconds(0.2), event -> {

            if (req_dx == -1) {
                if (pacman.getX() > 0 && walls[((int) pacman.getX() - blockSize) / blockSize][(int) pacman.getY() / blockSize] != 1) {
                    pacman.setX(pacman.getX() - blockSize);
                    pacman.setFill(pacmanLeft);
                }
            } else if (req_dx == 1) {
                if (pacman.getX() <= 560 && walls[((int) pacman.getX() + blockSize) / blockSize][(int) pacman.getY() / blockSize] != 1) {
                    pacman.setX(pacman.getX() + blockSize);
                    pacman.setFill(pacmanRight);

                }
            } else if (req_dy == -1) {
                if (pacman.getY() > 0 && walls[((int) pacman.getX()) / blockSize][((int) pacman.getY() - blockSize) / blockSize] != 1) {
                    pacman.setY(pacman.getY() - blockSize);
                    pacman.setFill(pacmanUp);

                }
            } else if (req_dy == 1) {
                if (pacman.getY() <= 340 && walls[((int) pacman.getX()) / blockSize][((int) pacman.getY() + blockSize) / blockSize] != 1) {
                    pacman.setY(pacman.getY() + blockSize);
                    pacman.setFill(pacmanDown);

                }
            }

            if (walls[(int) pacman.getX() / blockSize][(int) pacman.getY() / blockSize] == 0) {
                liveScore++;
                walls[(int) pacman.getX() / blockSize][(int) pacman.getY() / blockSize] = -1;
                for (Point point : Point.getAllPoints()) {
                    if (point.getCenterX() - 10 == pacman.getX() && point.getCenterY() - 10 == pacman.getY()) {
                        point.remove();
                        if (Point.getAllPoints().isEmpty()){
                            rest();
                        }
                        break;
                    }
                }
            }

            score.setText(String.valueOf(liveScore));

        });


        this.timer = new Timeline(frame);
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();


        // /pacman move
        //ghosts move
        KeyFrame frameGhost = new KeyFrame(Duration.seconds(0.3), event -> {

            for (Ghost ghost : Ghost.getAllGhosts()) {
                int random = (int) (Math.random() * (4));
                if (random == 0) {
                    if (ghost.getX() > 0 && walls[((int) ghost.getX() - blockSize) / blockSize][(int) ghost.getY() / blockSize] != 1) {
                        ghost.setX(ghost.getX() - blockSize);
                    }
                } else if (random == 1) {
                    if (ghost.getX() <= 560 && walls[((int) ghost.getX() + blockSize) / blockSize][(int) ghost.getY() / blockSize] != 1) {
                        ghost.setX(ghost.getX() + blockSize);
                    }
                } else if (random == 2) {
                    if (ghost.getY() > 0 && walls[((int) ghost.getX()) / blockSize][((int) ghost.getY() - blockSize) / blockSize] != 1) {
                        ghost.setY(ghost.getY() - blockSize);
                    }
                } else if (random == 3) {
                    if (ghost.getY() <= 340 && walls[((int) ghost.getX()) / blockSize][((int) ghost.getY() + blockSize) / blockSize] != 1) {
                        ghost.setY(ghost.getY() + blockSize);
                    }

                }

            }
        });

        this.timerGhost = new Timeline(frameGhost);
        timerGhost.setCycleCount(Timeline.INDEFINITE);
        timerGhost.play();
        // /ghosts move


        KeyFrame frameLose = new KeyFrame(Duration.seconds(0.01), event -> {
            for (Ghost ghost : Ghost.getAllGhosts()) {
                if (ghost.getX() == pacman.getX() && ghost.getY() == pacman.getY()) {
                    System.out.println(jon);
                    if (jon == 1) {
                        jon3.setImage(new Image(String.valueOf((getClass().getResource("pics/zabdar.jpg")))));
                        timer.stop();
                        timerGhost.stop();
                        try {
                            endGame();
                            jon--;
                            new Asli().start(stage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        jon--;
                        if (jon == 2) {
                            jon1.setImage(new Image(String.valueOf((getClass().getResource("pics/zabdar.jpg")))));
                            restart();
                        }

                        if (jon == 1) {
                            jon2.setImage(new Image(String.valueOf((getClass().getResource("pics/zabdar.jpg")))));
                            restart();
                        }
                    }
                }
            }
        });

        Timeline timerLose = new Timeline(frameLose);
        timerLose.setCycleCount(Timeline.INDEFINITE);
        timerLose.play();


        KeyFrame frameCheck = new KeyFrame(Duration.seconds(0.1), event -> {
            if (jon <= 0) {
                timerLose.stop();
            }
        });

        Timeline timerCheck = new Timeline(frameCheck);
        timerCheck.setCycleCount(Timeline.INDEFINITE);
        timerCheck.play();
    }


    public static void main(String[] args) {
        launch(args);
    }


}

