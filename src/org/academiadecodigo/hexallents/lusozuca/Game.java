package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;

public class Game {

    private Stage stage;
    private Player player;
    private Platform[] platforms;
    private Stair[] stairs;
    //private Platform platforms;
    private Enemy[] enemies;
    private int delay;
    private CollisionDetector collisionDetector;


    public Game(int cols, int rows, int delay) {
        stage = new Stage(cols, rows);
        this.delay = delay;
    }

    public void init() {
        stage.init();
        platforms = new Platform[4];
        platforms[0] = new Platform(0, stage.getRow() - Platform.BLOCK_SIZE, stage, 14);    //stage.getRow() - Platform.BLOCK_SIZE = quantidade de linhas do Stage - tamanho do bloco em linhas (não em pixels)
        platforms[1] = new Platform(6 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 14);
        platforms[2] = new Platform(0, 3 * Platform.BLOCK_SIZE, stage, 14);
        platforms[3] = new Platform(6 * Platform.BLOCK_SIZE, 0, stage, 14);

        stairs = new Stair[3];
        stairs[0] = new Stair(12 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 3);
        stairs[1] = new Stair(7 * Platform.BLOCK_SIZE, 3 * Platform.BLOCK_SIZE, stage, 3);
        stairs[2] = new Stair(12 * Platform.BLOCK_SIZE, 0, stage, 3);


        player= new Player(stage.makePosition(10,80));

    }


}
