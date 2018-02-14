package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObjects;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Stair;
import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;

public class Game {

    private Stage stage;
    private Player player;
    private GameObjects[] gameObjects;
    private Enemy[] enemies;
    private int delay;
    private CollisionDetector collisionDetector;


    public Game(int cols, int rows, int delay) {
        stage = new Stage(cols, rows);
        this.delay = delay;
    }

    public void init() {
        stage.init();

        gameObjects = new GameObjects[7];

        gameObjects[0] = new Platform(0, stage.getRow() - Platform.BLOCK_SIZE, stage, 14);    //stage.getRow() - Platform.BLOCK_SIZE = quantidade de linhas do Stage - tamanho do bloco em linhas (não em pixels)
        gameObjects[1] = new Platform(6 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 14);
        gameObjects[2] = new Platform(0, 3 * Platform.BLOCK_SIZE, stage, 14);
        gameObjects[3] = new Platform(6 * Platform.BLOCK_SIZE, 0, stage, 14);

        gameObjects[4] = new Stair(12 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 3);
        gameObjects[5] = new Stair(7 * Platform.BLOCK_SIZE, 3 * Platform.BLOCK_SIZE, stage, 3);
        gameObjects[6] = new Stair(12 * Platform.BLOCK_SIZE, 0, stage, 3);

        player= new Player(stage.makePosition(10,5*Platform.BLOCK_SIZE));

        collisionDetector = new CollisionDetector(gameObjects, player);

        player.setCollisionDetector(collisionDetector);



    }


}
