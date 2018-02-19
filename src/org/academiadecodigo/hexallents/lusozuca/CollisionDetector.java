package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.characters.Enemy;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.position.Position;


public class CollisionDetector {

    private GameObject[] gameObjects;
    private Player player;
    //private Enemy[] enemies;


    public CollisionDetector(GameObject[] gameObjects, Player player){

        this.gameObjects = gameObjects;
        this.player = player;
        //this.enemies = enemies;

    }

    public boolean checkForCollisions(){

        for (GameObject obj: gameObjects){

            if(player.getPos().equals(obj.getPos())){
                return true;
            }
        }
        return false;
    }

    public void gravityPull() throws InterruptedException {

        if (!checkForCollisions()) {

            player.getPos().moveDirection(Direction.DOWN, 1);
            //enemies.getPos().moveDirection(Direction.DOWN, 1);
        }

    }



}
