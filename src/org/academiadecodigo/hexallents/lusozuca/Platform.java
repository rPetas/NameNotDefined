package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.position.PlatformPosition;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Platform {

    private Rectangle rectangle;
    private PlatformPosition pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_SIZE = 5;   //5 colunas ou linhas


    public Platform(int col, int row, Stage stage, int numberOfBlocks){
        color=StageBackground.MAGENTA;
        pos = new PlatformPosition(col, row, stage, numberOfBlocks);
    }

}

