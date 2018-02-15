package org.academiadecodigo.hexallents.lusozuca.GameObjects;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.position.PlatformPosition;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;


public class Platform extends GameObject {

    private Position pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_SIZE = 5;


    public Platform(int col, int row, Stage stage, int numberOfBlocks){
        color=StageBackground.MAGENTA;
        pos = new PlatformPosition(col, row, stage, numberOfBlocks);

    }

    @Override
    public Position getPos(){
        return pos;
    }

}

