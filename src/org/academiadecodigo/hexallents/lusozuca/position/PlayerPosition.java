package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerPosition extends Position {

    Picture playerImage;

    //Player
    public PlayerPosition(int col, int row, Stage stage) {
        this.col = col;
        this.row = row;
        this.stage = stage;

        playerImage = new Picture(stage.colToPixel(getCol()), stage.rowToPixel(getRow()), "org/academiadecodigo/hexallents/lusozuca/images/front01.gif");
        rectangle = new Rectangle(stage.colToPixel(getCol()), stage.rowToPixel(getRow()), stage.CELL_SIZE*2, stage.CELL_SIZE*2);
        minX = rectangle.getX();
        maxX = rectangle.getX()+rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY()+rectangle.getHeight();
        this.color = StageBackground.NOCOLOR;
    }

    public void show() {
        rectangle.setColor(SimpleGfxColorMapper.getColor(getColor()));
        rectangle.fill();
        playerImage.draw();

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


