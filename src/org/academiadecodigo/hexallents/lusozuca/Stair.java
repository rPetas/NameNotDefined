package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.position.StairPosition;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Stair {

    private Rectangle rectangle;
    private StairPosition pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_SIZE = 5;   //5 colunas ou linhas


    public Stair(int col, int row, Stage stage, int numberOfBlocks){
        pos = new StairPosition(col, row, stage, numberOfBlocks);
    }


}
