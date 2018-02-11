package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;

public class Game {

    private Stage stage;
    private Player player;
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

        platforms = new Platform[3];


        //platforms[0] = new Platform(0, 40);

    }


}
