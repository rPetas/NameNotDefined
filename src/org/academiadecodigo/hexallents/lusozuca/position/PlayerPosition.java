package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerPosition extends Position {

    //Player
    public PlayerPosition(int col, int row, Stage stage) {
        this.col = col;
        this.row = row;
        this.stage = stage;
        rectangle = new Rectangle(stage.colToPixel(getCol()), stage.rowToPixel(getRow()), stage.CELL_SIZE, stage.CELL_SIZE);
        minX = rectangle.getX();
        maxX = rectangle.getX()+rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY()+rectangle.getHeight();
        this.color = StageBackground.NOCOLOR;
        show();
    }

/*    //Platform
    public PlayerPosition(int col, int row, Stage stage, int numberOfBlocks, StageBackground color) {
        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * Platform.BLOCK_SIZE * numberOfBlocks, Stage.CELL_SIZE * Platform.BLOCK_SIZE);
        this.color = color;
        show();
    }
    //Stairs
    public PlayerPosition(int col, int row, Stage stage, int numberOfBlocks) {
        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * Platform.BLOCK_SIZE, Stage.CELL_SIZE * Platform.BLOCK_SIZE * numberOfBlocks);
        this.color = StageBackground.GREEN;
        rectangle.fill();
        show();
    }
    */






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


    @Override
    public boolean equals(Object position) {
        if(position instanceof PlayerPosition){
            PlayerPosition pos= (PlayerPosition) position;
            return col == pos.getCol() && row == pos.getRow();
        }
        return false;
    }




}


