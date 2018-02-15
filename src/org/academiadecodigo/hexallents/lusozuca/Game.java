package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class Game {

    Rectangle;

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

        //Criação das plataformas: retângulos
        platforms = new Platform[4];
        platforms[0] = new Platform(0, stage.getRow() - Platform.BLOCK_SIZE, stage, 14);    //stage.getRow() - Platform.BLOCK_SIZE = quantidade de linhas do Stage - tamanho do bloco em linhas (não em pixels)
        platforms[1] = new Platform(6 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 14);
        platforms[2] = new Platform(0, 3 * Platform.BLOCK_SIZE, stage, 14);
        platforms[3] = new Platform(6 * Platform.BLOCK_SIZE, 0, stage, 14);

        //Criação das plataformas: imagens
        Picture picPlatform1 = new Picture(Stage.PADDING, stage.rowToPixel(stage.getRow() - Platform.BLOCK_SIZE), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/cloud.png");
        picPlatform1.draw();
        Picture picPlatform2 = new Picture(stage.colToPixel(6 * Platform.BLOCK_SIZE), stage.rowToPixel(6 * Platform.BLOCK_SIZE), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/platform.png");
        picPlatform2.draw();
        Picture picPlatform3 = new Picture(Stage.PADDING, stage.rowToPixel(3 * Platform.BLOCK_SIZE), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/platform.png");
        picPlatform3.draw();
        Picture picPlatform4 = new Picture(stage.colToPixel(6 * Platform.BLOCK_SIZE), stage.rowToPixel(0), "/Users/codecadet/Desktop/java/NameNotDefined/src/org/academiadecodigo/hexallents/lusozuca/images/platform.png");
        picPlatform4.draw();

        //Criação das escadas: retângulos
        stairs = new Stair[3];
        stairs[0] = new Stair(12 * Platform.BLOCK_SIZE, 6 * Platform.BLOCK_SIZE, stage, 3);
        stairs[1] = new Stair(7 * Platform.BLOCK_SIZE, 3 * Platform.BLOCK_SIZE, stage, 3);
        stairs[2] = new Stair(12 * Platform.BLOCK_SIZE, 0, stage, 3);

        //Criação das escadas: imagens


        player= new Player(stage.makePosition(10,5*Platform.BLOCK_SIZE));

        if (player.equals(stairs)) {
            System.out.println("equals...");
        } else {
            System.out.println("not equals...");
        }

    }


}
