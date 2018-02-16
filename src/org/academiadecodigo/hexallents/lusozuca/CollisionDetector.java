package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.position.Position;


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
                return true;
            }
        }
        return false;
    }

    public boolean isOnPlatform(Position position){

        for (GameObject obj: gameObjects){

            if(obj instanceof Platform) {

                if (position.equals(obj.getPos())) {
                    return true;
                }
            }
        }
        return false;
    }



}
