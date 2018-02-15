package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;

public class Game {

    private Stage stage;
    private Player player;
    private Stair[] stairs;
    private Platform[] platforms;
    private Enemy[] enemies;
    private int delay;
    private CollisionDetector collisionDetector;


    public Game(int cols, int rows, int delay) {
        stage = new Stage(cols, rows);
        this.delay = delay;
    }

    public void init() {
        stage.init();
        platforms = new Platform[5];
        platforms[0] = new Platform(0, stage.getRow() - Platform.BLOCK_SIZE, stage, 26);    //stage.getRow() - Platform.BLOCK_SIZE = quantidade de linhas do Stage - tamanho do bloco em linhas (não em pixels)
        platforms[1] = new Platform(14 * Platform.BLOCK_SIZE, 15 * Platform.BLOCK_SIZE, stage, 26);
        platforms[2] = new Platform(0, 11 * Platform.BLOCK_SIZE, stage, 26);
        platforms[3] = new Platform(14 * Platform.BLOCK_SIZE, 7 * Platform.BLOCK_SIZE, stage, 26);
        platforms[4] = new Platform(0, 3 * Platform.BLOCK_SIZE, stage, 26);

        stairs = new Stair[3];
        stairs[0] = new Stair(23 * Platform.BLOCK_SIZE, 15 * Platform.BLOCK_SIZE, stage, 4);
        stairs[1] = new Stair(16 * Platform.BLOCK_SIZE, 11 * Platform.BLOCK_SIZE, stage, 4);
        stairs[2] = new Stair(23 * Platform.BLOCK_SIZE, 0, stage, 4);


        player= new Player(stage.makePosition(10,5 * Platform.BLOCK_SIZE));

    }


}
