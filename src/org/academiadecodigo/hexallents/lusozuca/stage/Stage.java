package org.academiadecodigo.hexallents.lusozuca.stage;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.position.CharacterPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Stage {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 5;
    private Rectangle rectangle;
    private int column;
    private int row;


    public Stage(int cols, int rows){
        column = cols;
        row = rows;

    }

    // Defining a new rgb parameter to background color blue

    Color color = new Color(44,219,255);

    //Creates canvas
    public void init(){
        rectangle = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        //Background white will be replaced by background image
        rectangle.setColor(color);
        rectangle.fill();
        // Background image replacing white background
        Picture backGroundPlatform = new Picture(Stage.PADDING, this.row - Platform.BLOCK_SIZE, "resources/images/back_ground.png");
        backGroundPlatform.draw();





    }

    public int getCol(){
        return column;
    }

    public int getRow(){
        return row;
    }

    public int getWidth(){
        return column*CELL_SIZE;
    }

    public int getHeight(){
        return row*CELL_SIZE;
    }

    public int getX(){
        return rectangle.getX();
    }

    public int getY(){
        return rectangle.getY();
    }

    public int colToPixel(int column) {
        return column * CELL_SIZE + PADDING;
    }

    public int rowToPixel(int row) {
        return row * CELL_SIZE + PADDING;
    }

    public CharacterPosition makePosition(int col, int row){
        return new CharacterPosition(col, row, this);
    }

}