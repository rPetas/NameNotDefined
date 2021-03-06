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
    private Sound gameMusic;
    private boolean gameOver;


    public Game(int cols, int rows, int delay) throws InterruptedException {
        stage = new Stage(cols, rows);
        this.delay = delay;
        Picture menuScreen = new Picture(stage.PADDING,stage.PADDING,"resources/otherScreenz/bg_game.png");
        menuScreen.draw();
        Thread.sleep(5000);
        menuScreen.delete();
    }

    public void init() {
        stage.init();

        gameObjects = new GameObject[10];
        //Platform
        gameObjects[0] = new Platform(0, stage.getRow()-3, stage, 26);    //stage.getRow() - Platform.BLOCK_SIZE = quantidade de linhas do Stage - tamanho do bloco em linhas (não em pixels)
        gameObjects[1] = new Platform(14 * Platform.BLOCK_SIZE, 15 * Platform.BLOCK_SIZE, stage, 26);
        gameObjects[2] = new Platform(0, 11 * Platform.BLOCK_SIZE, stage, 26);
        gameObjects[3] = new Platform(14 * Platform.BLOCK_SIZE, 7 * Platform.BLOCK_SIZE, stage, 26);
        gameObjects[4] = new Platform(0, 3 * Platform.BLOCK_SIZE, stage, 26);

        //Stairs
        gameObjects[5] = new Stair(23 * Platform.BLOCK_SIZE, 15 * Platform.BLOCK_SIZE, stage, 4);
        gameObjects[6] = new Stair(16 * Platform.BLOCK_SIZE, 11 * Platform.BLOCK_SIZE, stage, 4);
        gameObjects[7] = new Stair(23 * Platform.BLOCK_SIZE, 7 * Platform.BLOCK_SIZE, stage, 4);
        gameObjects[8] = new Stair(16 * Platform.BLOCK_SIZE, 3 * Platform.BLOCK_SIZE, stage, 4);
        gameObjects[9] = new Stair(23 * Platform.BLOCK_SIZE, -1 * Platform.BLOCK_SIZE, stage, 4);


        //Criação das plataformas: imagens
        Picture picPlatform1 = new Picture(10, stage.rowToPixel(stage.getRow() - 20), "resources/images/first_step.png");
        picPlatform1.draw();
        Picture picPlatform2 = new Picture(314, stage.rowToPixel(stage.getRow() - 32), "resources/images/cloud.png");
        picPlatform2.draw();
        Picture picPlatform3 = new Picture(10, stage.rowToPixel(stage.getRow() - 53), "resources/images/cloud.png");
        picPlatform3.draw();
        Picture picPlatform4 = new Picture(314, stage.rowToPixel(stage.getRow() - 72), "resources/images/cloud.png");
        picPlatform4.draw();
        Picture picPlatform5 = new Picture(10, stage.rowToPixel(stage.getRow() - 93), "resources/images/cloud.png");
        picPlatform5.draw();


        player= new Player(stage.makePosition(10,80));

        collisionDetector = new CollisionDetector(gameObjects, player);

        player.setCollisionDetector(collisionDetector);

    }

    public void start() throws InterruptedException {

        gameMusic = new Sound("/resources/sounds/music.wav");
        gameMusic.loopIndef();

        while(!gameOver){

            collisionDetector.gravityPull();

            if (player.isJumping()) {
                collisionDetector.manageJump();
            }

            if(collisionDetector.checkEnd()){
                end();
            }

            Thread.sleep(delay);
        }
        gameMusic.stop();
        gameMusic.close();
        Sound endMusic = new Sound("/resources/sounds/knockknock.wav");
        endMusic.play(true);
        Picture endScreen = new Picture(stage.getX(), stage.getY(), "resources/otherScreenz/final_screen_v2.png");
        endScreen.draw();

    }

    public void end(){
        gameOver=true;
    }


}
