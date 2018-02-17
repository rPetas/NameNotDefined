package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Stair;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;


public class CollisionDetector {

    private GameObject[] gameObjects;
    private Player player;
    private int jumpCounter;


    public CollisionDetector(GameObject[] gameObjects, Player player){

        this.gameObjects = gameObjects;
        this.player = player;

    }


    public boolean onPlatform(){
        for (GameObject obj : gameObjects){
            if(obj instanceof Platform) {
                if (player.getPos().equals(obj.getPos())) {
                    return true;
                }
            }
        }return false;
    }

    public boolean onStairs(){
        for (GameObject object : gameObjects){
            if(object instanceof Stair){
               if(player.getPos().equals(object.getPos())){
                   return true;
               }
            }
        }return false;
    }

    public void gravityPull(){

        if (!onPlatform()&&!onStairs()) {

            player.getPos().moveDirection(Direction.DOWN, 1);

            player.setGravity();

            return;
        }
        player.setOffGravity();
    }

    public void manageJump(){

        if(jumpCounter < 9) {

            jumpCounter++;

            player.getPos().moveDirection(Direction.UP, 2);

            return;
        }
        jumpCounter = 0;
        player.setJumpOver();
    }



}
