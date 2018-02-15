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



    @Override
    public boolean equals(Object position) {
        if(position instanceof PlayerPosition){
            PlayerPosition pos = (PlayerPosition) position;
            return col == pos.getCol() && row == pos.getRow();
        }
        return false;
    }



}
