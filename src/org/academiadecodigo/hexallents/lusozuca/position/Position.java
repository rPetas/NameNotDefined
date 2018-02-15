package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Position {

    //---PROPERTIES---
    protected Rectangle rectangle;
    protected Stage stage;
    protected int col;
    protected int row;
    protected StageBackground color;
    protected int minX;
    protected int maxX;
    protected int minY;
    protected int maxY;

    abstract void show();

    public void hide(){
        rectangle.delete();
    }

    public Stage getStage() {
        return stage;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public StageBackground getColor() {
        return color;

    }

    public void setColor(StageBackground color) {
        rectangle.setColor(SimpleGfxColorMapper.getColor(color));
        this.color = color;
        show();
    }


    // this method equals is verifying if the rectangles are not overlapping;
    // if it returns true it means that there is no collision;
    // it is counter-intuitive;
    @Override
    public boolean equals(Object position) {
        if(position instanceof Position){
            Position pos = (Position) position;
            return this.minX < pos.maxX && this.maxX > pos.minX &&
                    this.minY < pos.maxY && this.maxY > pos.minY;
        }
        return false;
    }



}