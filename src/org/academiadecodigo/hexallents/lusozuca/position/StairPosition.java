package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class StairPosition extends Position {

    public StairPosition(int col, int row, Stage stage, int numberOfBlocks) {

        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * Platform.BLOCK_SIZE, Stage.CELL_SIZE * Platform.BLOCK_SIZE * numberOfBlocks);
        color = StageBackground.GREEN;
        minX = rectangle.getX();
        maxX = rectangle.getX()+rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY()+rectangle.getHeight();
        show();
    }

    @Override
    public void show() {
        rectangle.setColor(SimpleGfxColorMapper.getColor(getColor()));
        rectangle.fill();
    }

}
