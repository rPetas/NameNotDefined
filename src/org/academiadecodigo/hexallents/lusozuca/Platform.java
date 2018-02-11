package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Platform {

    private Rectangle rectangle;
    private Position pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_WIDTH = 40;
    public static final int BLOCK_HEIGHT = 10;


    public Platform(int col, int row, Stage stage, int numberOfBlocks){
        pos = new Position(col, row, stage);
        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * BLOCK_WIDTH * numberOfBlocks, Stage.CELL_SIZE * BLOCK_HEIGHT);
        rectangle.setColor(SimpleGfxColorMapper.getColor(StageBackground.MAGENTA));
        rectangle.fill();
        //makePlatform(1);
        pos.show();
    }


/*    public Platform makePlatform(int numberOfBlocks) {
        Platform[] platforms = new Platform[numberOfBlocks];
        for (int i = 0; i < numberOfBlocks; i++) {
            return platforms[i] = new Platform(0, 0, stage, 20);
        }
        return null;
    }*/


}
