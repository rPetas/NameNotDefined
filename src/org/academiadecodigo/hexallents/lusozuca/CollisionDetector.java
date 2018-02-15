package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;

import java.util.Arrays;

public class CollisionDetector {

    private GameObject[] gameObjects;
    private Player player;

    public CollisionDetector(GameObject[] gameObjects, Player player){

        this.gameObjects = gameObjects;
        this.player = player;

    }

    public boolean checkForCollisions(){

        for (GameObject obj: gameObjects){

            if(player.getPos().equals(obj.getPos())){
                System.out.println(obj.toString());
                return true;
            }
        }

        System.out.println("at least does this");
        return false;
    }

}
