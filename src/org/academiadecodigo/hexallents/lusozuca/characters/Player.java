package org.academiadecodigo.hexallents.lusozuca.characters;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.Sound;
import org.academiadecodigo.hexallents.lusozuca.position.CharacterPosition;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player extends GameObject implements KeyboardHandler {

    private Direction vertical;
    private Direction horizontal;
    private boolean jump;
    private Sound jumpSound;
    private CharacterPosition pos;

    public Player(Position pos) {
        super(pos);
        this.pos = (CharacterPosition) pos;
        pos.setColor(StageBackground.RED);
        vertical = Direction.DOWN;
        horizontal = Direction.NONE;

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

    //FIXME: Ainda está por resolver a situação de poder andar para a direita e para a esquerda dentro das plataformas.
    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                horizontal = Direction.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                horizontal = Direction.RIGHT;
                break;
            case KeyboardEvent.KEY_SPACE:
                vertical = Direction.UP;
                jumpSound.play(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                horizontal = Direction.NONE;
                break;
            case KeyboardEvent.KEY_RIGHT:
                horizontal = Direction.NONE;
                break;
            case KeyboardEvent.KEY_SPACE:
                vertical = Direction.NONE;
                jumpSound.play(true);
                break;
        }

    }

    public void move() {
        pos.moveDirection(vertical, 1);
        pos.moveDirection(horizontal, 1);
    }

    public void setDirection(Direction direction, boolean horizontal) {
        if (horizontal) {
            this.horizontal = direction;
        } else {
            vertical = direction;
        }
    }

    public void stop(boolean horizontal) {
        if (horizontal) {
            this.horizontal = Direction.NONE;
        } else {
            vertical = Direction.NONE;
        }
    }

    public Position getPos() {
        return pos;
    }

    public boolean isJumping() {
        return vertical == Direction.UP;
    }

}
