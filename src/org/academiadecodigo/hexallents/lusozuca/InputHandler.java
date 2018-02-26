package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class InputHandler implements KeyboardHandler {

    private Menu menu;
    private Game game;

    public InputHandler(Menu menu, Game game) {
        this.menu = menu;
        this.game = game;
        Keyboard kb = new Keyboard(this);
        KeyboardEvent startKey = new KeyboardEvent();
        startKey.setKey(KeyboardEvent.KEY_S);
        startKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(startKey);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        menu.delete();
        game.run();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
