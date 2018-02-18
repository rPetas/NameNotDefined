package org.academiadecodigo.hexallents.lusozuca.characters;

import org.academiadecodigo.hexallents.lusozuca.CollisionDetector;
import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.Sound;
import org.academiadecodigo.hexallents.lusozuca.position.CharacterPosition;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {
    private CharacterPosition pos;
    private Stage stage;
    private CollisionDetector collisionDetector;
    private boolean jump;
    private boolean gravity = true; // when it's true, activates the pullDown method, so he falls
    private boolean dead = false; // game stops and only thing u can do to continue is restart or rewind;
    private Sound jumpSound;


    public Player(CharacterPosition startingCharacterPosition) {

        this.pos = startingCharacterPosition;

        pos.setColor(StageBackground.BLUE);

        jumpSound = new Sound("/resources/sounds/Mario-jump-sound-effect-free-download.wav");

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

    @Override //Ainda está por resolver a situação de poder andar para a direita e para a esquerda
    //dentro das plataformas.
    public void keyPressed(KeyboardEvent e) {
        //if(!isDead()&&!isGravity()){

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                pos.moveDirection(Direction.LEFT, 1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                pos.moveDirection(Direction.RIGHT, 1);
                break;
        }

        if (e.getKey() == KeyboardEvent.KEY_SPACE && !gravity && !collisionDetector.onStairs()) {
            jump=true;
            jumpSound.play(true);
        }

        if (collisionDetector.onStairs()) {

            switch (e.getKey()) {
                case KeyboardEvent.KEY_UP:
                    pos.moveDirection(Direction.UP, 1);
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if(!collisionDetector.onPlatform()) {
                        pos.moveDirection(Direction.DOWN, 1);
                        break;
                    }
            }
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }
    public CharacterPosition getPos() {
        return pos;
    }

    public boolean isDead() {
        return dead;
    }

    public void die() {
        dead = true;
    }

    public void setOffGravity() {
        gravity = false;
    }
    public void setGravity() {
        gravity = true;
    }
    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }
    public boolean isJumping(){
        return jump;
    }
    public void setJumpOver(){
        jump = false;
    }
}
