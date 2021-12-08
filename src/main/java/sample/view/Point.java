package sample.view;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Point extends Circle {
    private static ArrayList<Point> allPoints = new ArrayList<>();
    private ImagePattern point = new ImagePattern(new Image(String.valueOf((getClass().getResource("pics/cop/smalldot.png")))));
    private AnchorPane anchorPane;

    public Point(double x, double y,AnchorPane anchorPane) {
        super(x + 10, y + 10, 10);
        this.setFill(point);
        this.anchorPane=anchorPane;
        allPoints.add(this);
    }

    public static ArrayList<Point> getAllPoints() {
        return allPoints;
    }

    public void remove() {
        anchorPane.getChildren().remove(this);
        allPoints.remove(this);
    }
}

