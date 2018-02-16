package org.academiadecodigo.hexallents.lusozuca.characters;
import org.academiadecodigo.hexallents.lusozuca.CollisionDetector;
import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.position.PlayerPosition;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

public class Player implements KeyboardHandler {
    private Position pos;
    private Stage stage;
    private CollisionDetector collisionDetector;
    private boolean gravity = false; // when it's true, activates the pullDown method, so he falls
    private boolean dead = false; // game stops and only thing u can do to continue is restart or rewind;


    public Player(PlayerPosition startingPlayerPosition){

        this.pos = startingPlayerPosition;

        pos.setColor(StageBackground.BLUE);

        Keyboard k = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent jump = new KeyboardEvent();
        jump.setKey(KeyboardEvent.KEY_SPACE);
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(up);
        k.addEventListener(down);
        k.addEventListener(left);
        k.addEventListener(right);
        k.addEventListener(jump);

    }

    @Override
    public void keyPressed(KeyboardEvent e){
        //if(!isDead()&&!isGravity()){

            switch (e.getKey()) {
                case KeyboardEvent.KEY_LEFT:
                    getPos().moveDirection(Direction.LEFT, 1);
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    getPos().moveDirection(Direction.RIGHT, 1);
                    break;
                case KeyboardEvent.KEY_UP:
                    getPos().moveDirection(Direction.UP, 1);
                    break;
                case KeyboardEvent.KEY_DOWN:
                    getPos().moveDirection(Direction.DOWN, 1);
                    break;
                case KeyboardEvent.KEY_SPACE:
                    getPos().moveDirection(Direction.UP, 3);
                    gravity = true;
            }
           // }


        }
       /* if (!isDead()&& isGravity()){
            switch (e.getKey()){
                case KeyboardEvent.KEY_LEFT:
                    getPos().moveDirection(Direction.LEFT,1);
                    break;

                case KeyboardEvent.KEY_RIGHT:
                    getPos().moveDirection(Direction.RIGHT,1);
                    break;

            }
        }*/


    public void gravityPull(int delay) throws InterruptedException {

        while (!collisionDetector.checkForCollisions()) {

            Thread.sleep(delay);

            getPos().moveDirection(Direction.DOWN, 1);
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }



    public Position getPos(){
        return pos;
    }

    public boolean isDead(){
        return dead;
    }

    public void die(){
        dead = true;
    }

    public boolean isGravity() {
        return gravity;
    }
}
