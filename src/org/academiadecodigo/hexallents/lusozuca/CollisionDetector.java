package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObjects;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;

public class CollisionDetector {

    private GameObjects[] gameObjects;
    private Player player;

    public CollisionDetector(GameObjects[] gameObjects, Player player){

        this.gameObjects = gameObjects;
        this.player = player;

    }

    public void checkForCollisions(){

    }

}
