package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObjectsFactory;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Main {
    public static void main(String[] args) {
        Menu startScreen = new Menu("resources/otherScreenz/bg_game.png");

        Stage stage = new Stage(200, 100);

        GameObject[] go = stage.getGameObjects();
        Player player = GameObjectsFactory.getPlayer(10, 80, stage);
        CollisionDetector collisionDetector = new CollisionDetector(go, player);

        Game g = new Game(200, 100, 50, collisionDetector, player);

        InputHandler keyboardHandler = new InputHandler(startScreen, g);
        g.start();

    }
}