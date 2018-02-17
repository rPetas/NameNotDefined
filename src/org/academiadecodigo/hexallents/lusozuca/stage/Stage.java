package org.academiadecodigo.hexallents.lusozuca.stage;

import org.academiadecodigo.hexallents.lusozuca.position.PlayerPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

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

    //Creates canvas
    public void init(){
        rectangle = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        rectangle.fill();
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

    public PlayerPosition makePosition(int col, int row){
        return new PlayerPosition(col, row, this);
    }

}