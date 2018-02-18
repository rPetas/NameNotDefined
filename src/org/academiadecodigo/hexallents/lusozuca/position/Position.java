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

    public void moveDirection(Direction direction, int distance) {

        int previousCol= getCol();
        int previousRow= getRow();

        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }
        rectangle.translate((getCol()-previousCol)*Stage.CELL_SIZE,(getRow()-previousRow)*Stage.CELL_SIZE);
        representation.translate((getCol()-previousCol)*Stage.CELL_SIZE,(getRow()-previousRow)*Stage.CELL_SIZE);
        minX = rectangle.getX();
        maxX = rectangle.getX() + rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY() + rectangle.getHeight();
    }

    public void moveUp(int distance) {
        int maxRowsUp = distance < getRow() ? distance : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
    }


    public void moveDown(int distance) {
        int maxRowsDown = distance > getStage().getRow() - (getRow() + 1) ? getStage().getRow() - (getRow() + 1) : distance;
        setPos(getCol(), getRow() + maxRowsDown);
    }


    public void moveLeft(int distance) {
        int maxRowsLeft = distance < getCol() ? distance : getCol();
        setPos(getCol() - maxRowsLeft, getRow());
    }


    public void moveRight(int distance) {
        int maxRowsRight = distance > getStage().getCol() - (getCol() + 1) ? getStage().getCol() - (getCol() + 1) : distance;
        setPos(getCol() + maxRowsRight, getRow());
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

           if((Math.abs(vectorAX - vectorBX) < (this.rectangle.getWidth()) + (pos.rectangle.getWidth()/2))&&
                (Math.abs(vectorAY - vectorBY) < (this.rectangle.getHeight()) + (pos.rectangle.getHeight()/2))) {
                return true;
            }

        }
        return false;
    }

}


