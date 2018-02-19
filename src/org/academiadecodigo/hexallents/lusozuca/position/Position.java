package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

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
    protected Picture representation;


    public abstract void show();

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



    public Rectangle getRectangle(){
        return rectangle;
    }


    @Override
    public boolean equals(Object position) {
        if(position instanceof Position){
            Position pos = (Position) position;

            int vectorAX = (this.minX + this.maxX)/2;
            int vectorAY = (this.minY + this.maxY)/2;

            int vectorBX = (pos.minX + pos.maxX)/2;
            int vectorBY = (pos.minY + pos.maxY)/2;

           if((Math.abs(vectorAX - vectorBX) < (this.representation.getWidth()/2) + (pos.rectangle.getWidth()/2))&&
                (Math.abs(vectorAY - vectorBY) < (this.representation.getHeight()/2) + (pos.rectangle.getHeight()/2))) {
                return true;
            }

        }
        return false;
    }

}


