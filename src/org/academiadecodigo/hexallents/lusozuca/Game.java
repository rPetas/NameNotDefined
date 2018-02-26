package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private final CollisionDetector collisionDetector;
    private final Player player;
    private Stage stage;
    private int delay;
    private boolean gameOver;
    private volatile boolean running;

    public Game(int cols, int rows, int delay, CollisionDetector collisionDetector, Player player) {
        this.player = player;
        this.delay = delay;
        this.collisionDetector = collisionDetector;
        stage = new Stage(cols, rows);
    }

    public void start() {

        Sound gameMusic = new Sound("/resources/sounds/music.wav");
        gameMusic.loopIndef();

        while (!gameOver) {

            if (!isRunning()) {
                continue;
            }

            collisionDetector.gravityPull();

            if (player.isJumping()) {
                collisionDetector.manageJump();
            }

            player.move();

            if (collisionDetector.checkEnd()) {
                end();
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        gameMusic.stop();
        gameMusic.close();
        Sound endMusic = new Sound("/resources/sounds/knockknock.wav");
        endMusic.play(true);
        Picture endScreen = new Picture(stage.getX(), stage.getY(), "resources/otherScreenz/final_screen_v2.png");
        endScreen.draw();

    }

    public void end() {
        gameOver = true;
    }

    public boolean isRunning() {
        return running;
    }

    public void run() {
        running = true;
    }
}
