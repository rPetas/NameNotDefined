package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;

public class Game {

    private Stage stage;
    private Player player;
    private Platform[] platforms;
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

        platforms = new Platform[3];



        platforms = new Platform[2];
        platforms[0] = new Platform(0, stage.getRow() - Platform.BLOCK_HEIGHT, stage, 3);
        platforms[1] = new Platform(0, stage.getRow() - Platform.BLOCK_HEIGHT, stage, 3);
        //platforms[1] = new Platform(0, 30, stage, 1);
        //Platform platform1 = new Platform(100, 0, stage, 20);
        //platforms.makePlatform(1);

        player= new Player(stage.makePosition(200,80));
    }


}
