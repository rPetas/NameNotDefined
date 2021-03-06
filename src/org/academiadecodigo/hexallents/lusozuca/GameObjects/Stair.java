package org.academiadecodigo.hexallents.lusozuca.GameObjects;

import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.position.StairPosition;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Stair extends GameObject {

    private Rectangle rectangle;
    private StairPosition pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_SIZE = 5;   //5 colunas ou linhas


    public Stair(int col, int row, Stage stage, int numberOfBlocks){
        pos = new StairPosition(col, row, stage, numberOfBlocks);
    }

    @Override
    public Position getPos(){
        return pos;
    }


}
