package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlatformPosition extends Position {

    public PlatformPosition(int col, int row, int numberOfBlocks) {
        rectangle = new Rectangle(Stage.colToPixel(col), Stage.rowToPixel(row),
                Stage.CELL_SIZE * Platform.BLOCK_SIZE * numberOfBlocks, Stage.CELL_SIZE * Platform.BLOCK_SIZE);

        color = StageBackground.NOCOLOR;
        minX = rectangle.getX();
        maxX = rectangle.getX() + rectangle.getWidth();
        minY = rectangle.getY();
        maxY = rectangle.getY() + rectangle.getHeight();
        //show();
    }

    @Override
    public void show() {
        rectangle.setColor(SimpleGfxColorMapper.getColor(getColor()));
        rectangle.fill();

    }

    @Override
    public String toString() {
        return rectangle.toString();
    }
}
