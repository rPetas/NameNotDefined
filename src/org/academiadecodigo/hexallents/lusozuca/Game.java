package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Stair;
import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;



public class Game {

    private Stage stage;
    private Player player;
    private GameObject[] gameObjects;
    private Enemy[] enemies;
    private int delay;
    private CollisionDetector collisionDetector;


    public Game(int cols, int rows, int delay) {
        stage = new Stage(cols, rows);
        this.delay = delay;
    }

    public void init() {
        stage.init();

        gameObjects = new GameObject[7];

        gameObjects[0] = new Platform(0, stage.getRow() - Platform.BLOCK_SIZE, stage, 14);
        gameObjects[1] = new Platform(6 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 14);
        gameObjects[2] = new Platform(0, 3 * Platform.BLOCK_SIZE, stage, 14);
        gameObjects[3] = new Platform(6 * Platform.BLOCK_SIZE, 0, stage, 14);

        gameObjects[4] = new Stair(12 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 3);
        gameObjects[5] = new Stair(7 * Platform.BLOCK_SIZE, 3 * Platform.BLOCK_SIZE, stage, 3);
        gameObjects[6] = new Stair(12 * Platform.BLOCK_SIZE, 0, stage, 3);

        /*//Criação das plataformas: imagens
        Picture picPlatform1 = new Picture(Stage.PADDING, stage.rowToPixel(stage.getRow() - Platform.BLOCK_SIZE), "cloud.png");
        picPlatform1.draw();
        Picture picPlatform2 = new Picture(stage.colToPixel(6 * Platform.BLOCK_SIZE), stage.rowToPixel(6 * Platform.BLOCK_SIZE), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/platform.png");
        picPlatform2.draw();
        Picture picPlatform3 = new Picture(Stage.PADDING, stage.rowToPixel(3 * Platform.BLOCK_SIZE), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/platform.png");
        picPlatform3.draw();
        Picture picPlatform4 = new Picture(stage.colToPixel(6 * Platform.BLOCK_SIZE), stage.rowToPixel(0), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/platform.png");
        picPlatform4.draw();*/

        player= new Player(stage.makePosition(10,5*Platform.BLOCK_SIZE));

        collisionDetector = new CollisionDetector(gameObjects, player);

        player.setCollisionDetector(collisionDetector);

    }

    public void start() throws InterruptedException {

        while(true){

            Thread.sleep(delay);

            collisionDetector.gravityPull();

        }
    }


}
