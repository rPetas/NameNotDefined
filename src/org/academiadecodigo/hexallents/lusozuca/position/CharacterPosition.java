package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CharacterPosition extends Position {

    private PlayerAnimations playerAnimations;


    //Player
    public CharacterPosition(int col, int row, Stage stage) {
        this.col = col;
        this.row = row;
        this.stage = stage;
        rectangle = new Rectangle(stage.colToPixel(getCol()), stage.rowToPixel(getRow()), 23, 30);
        this.representation = new Picture(rectangle.getX(), rectangle.getY(), "front01.png");
        this.playerAnimations = new PlayerAnimations(this);
        minX = rectangle.getX();
        maxX = rectangle.getX()+rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY()+rectangle.getHeight();
        this.color = StageBackground.NOCOLOR;
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
        representation.translate((getCol()-previousCol)*Stage.CELL_SIZE,(getRow()-previousRow)*Stage.CELL_SIZE);
        minX = representation.getX();
        maxX = representation.getMaxX();
        minY = representation.getY();
        maxY = representation.getMaxY();
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





    public void show() {
        representation.draw();

    }

    public void hide() {
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



}


