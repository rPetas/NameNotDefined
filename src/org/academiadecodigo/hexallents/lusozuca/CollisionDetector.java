package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Stair;
import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class CollisionDetector {

    private GameObject[] gameObjects;
    private Player player;
    private int jumpCounter;
    private EndGamePosition endGamePosition;


    public CollisionDetector(GameObject[] gameObjects, Player player){

        this.gameObjects = gameObjects;
        this.player = player;
        endGamePosition = new EndGamePosition();
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

        if (!onPlatform() && !onStairs()) {

            player.getPos().moveDirection(Direction.DOWN, 1);

            player.setGravity();

            return;
        }
        player.setOffGravity();
    }

    public void manageJump(){

        if(jumpCounter < 8) {

            jumpCounter++;

            player.getPos().moveDirection(Direction.UP, 2);

            return;
        }
        jumpCounter = 0;
        player.setJumpOver();
    }

    public boolean checkEnd(){
        if (player.getPos().equals(endGamePosition)) {
            return true;
        }
        return false;
    }

    private class EndGamePosition extends Position{

        private EndGamePosition(){
            rectangle = new Rectangle(585, 30, 10, 10);

            minX = rectangle.getX();
            maxX = rectangle.getX()+rectangle.getWidth();
            minY = rectangle.getY();
            maxY = rectangle.getY()+rectangle.getHeight();
        }

        @Override
        public void show() {

        }
    }



}
