package org.academiadecodigo.hexallents.lusozuca.GameObjects;

import org.academiadecodigo.hexallents.lusozuca.position.PlatformPosition;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Platform extends GameObjects{

    private Rectangle rectangle;
    private PlatformPosition pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_SIZE = 5;   //5 colunas ou linhas
    //public static final int BLOCK = 54;  //in pixels


    public Platform(int col, int row, Stage stage, int numberOfBlocks){
        color=StageBackground.MAGENTA;
        pos = new PlatformPosition(col, row, stage, numberOfBlocks);

        //pos.setColor(StageBackground.MAGENTA);
        //rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * BLOCK_SIZE * numberOfBlocks, Stage.CELL_SIZE * BLOCK_SIZE);
        //rectangle.setColor(SimpleGfxColorMapper.getColor(StageBackground.MAGENTA));
        //rectangle.fill();
        //makePlatform(1);
        //pos.show();
    }


/*    public Platform makePlatform(int numberOfBlocks) {
        Platform[] platforms = new Platform[numberOfBlocks];
        for (int i = 0; i < numberOfBlocks; i++) {
            return platforms[i] = new Platform(0, 0, stage, 20);
        }
        return null;
    }*/


}


/*
    public Platform(int col, int row, Stage stage, int numberOfBlocks){
        pos = new PlayerPosition(col, row, stage);
        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * BLOCK_WIDTH * numberOfBlocks, Stage.CELL_SIZE * BLOCK_HEIGHT);
        rectangle.setColor(SimpleGfxColorMapper.getColor(StageBackground.MAGENTA));
        rectangle.fill();
        //makePlatform(1);
        pos.show();
    }
 */
