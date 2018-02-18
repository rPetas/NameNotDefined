package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StairPosition extends Position {

    public StairPosition(int col, int row, Stage stage, int numberOfBlocks) {

        Picture stairs = new Picture(stage.colToPixel(col), stage.rowToPixel(row), "org/academiadecodigo/hexallents/lusozuca/images/stair.png");
        stairs.draw();
        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * Platform.BLOCK_SIZE, Stage.CELL_SIZE * Platform.BLOCK_SIZE * numberOfBlocks);
        color = StageBackground.GREEN;
        minX = rectangle.getX();
        maxX = rectangle.getX()+rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY()+rectangle.getHeight();


    }

    @Override
    public void show() {
        rectangle.setColor(SimpleGfxColorMapper.getColor(getColor()));
        rectangle.fill();
    }

}
