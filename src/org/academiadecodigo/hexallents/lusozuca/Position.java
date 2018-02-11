package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageColor;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private Rectangle rectangle;
    private Stage stage;
    private int col;
    private int row;
    private StageColor color;


    public Position(int col, int row, Stage stage) {
        this.col = col;
        this.row = row;
        this.stage = stage;
        rectangle = new Rectangle();
        this.color = StageColor.NOCOLOR;
        show();
    }

    public void show() {
        rectangle.setColor(SimpleGfxColorMapper.getColor(getColor()));
        rectangle.fill();
    }

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

    public StageColor getColor() {
        return color;

    }

    public void setColor(StageColor color) {
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
    }



    public void moveUp(int distance) {
        int maxRowsUp = distance < getRow() ? distance : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
    }


    public void moveDown(int distance) {
        int maxRowsDown = distance > getStage().getRow() - (getRow() + 1) ? getStage().getRow() - (getRow() + 1) : distance;
        setPos(getCol(), getRow() - maxRowsDown);
    }


    public void moveLeft(int distance) {
        int maxRowsLeft = distance < getCol() ? distance : getCol();
        setPos(getCol() - maxRowsLeft, getRow());
    }


    public void moveRight(int distance) {
        int maxRowsRight = distance > getStage().getCol() - (getCol() + 1) ? getStage().getCol() - (getCol() + 1) : distance;
        setPos(getCol() + maxRowsRight, getRow());
    }


    @Override
    public boolean equals(Object position) {
        if(position instanceof Position){
            Position pos= (Position) position;
            return col == pos.getCol() && row == pos.getRow();
        }
        return false;
    }




}


