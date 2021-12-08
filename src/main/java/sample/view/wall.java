package sample.view;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class wall extends Rectangle {
    private static ArrayList<wall> allWalls=new ArrayList<>();
    public wall(double x,double y){
        super(x*20,y*20,20,20);
        allWalls.add(this);
    }

    public static ArrayList<wall> getAllWalls() {
        return allWalls;
    }

    //public static boolean pacmanArrivedToWall(Rectangle wall){return wall.getBoundsInParent().intersects(Game.pacman.getLayoutBounds());}
}