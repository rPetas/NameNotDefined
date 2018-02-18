package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerPosition extends Position {


    //Player
    public PlayerPosition(int col, int row, Stage stage) {
        this.col = col;
        this.row = row;
        this.stage = stage;
        rectangle = new Rectangle(stage.colToPixel(getCol()), stage.rowToPixel(getRow()), 23, 30);
        this.representation = new Picture(rectangle.getX(), rectangle.getY(), "front01.png");
        minX = rectangle.getX();
        maxX = rectangle.getX()+rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY()+rectangle.getHeight();
        this.color = StageBackground.NOCOLOR;
        show();
    }

    public void show() {
        rectangle.setColor(SimpleGfxColorMapper.getColor(getColor()));
        rectangle.fill();
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


