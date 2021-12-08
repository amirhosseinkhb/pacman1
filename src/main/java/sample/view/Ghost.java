package sample.view;

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class Ghost extends Rectangle {
    private static ArrayList<Ghost> allGhosts=new ArrayList<>();
    private int x1;
    private int y1;
    public Ghost(int x, int y, ImagePattern imagePattern){
        super(x,y,20,20);
        this.x1=x;
        this.y1=y;
        this.setFill(imagePattern);
        allGhosts.add(this);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public static ArrayList<Ghost> getAllGhosts() {
        return allGhosts;
    }
}