package org.academiadecodigo.hexallents.lusozuca.characters;

import org.academiadecodigo.hexallents.lusozuca.Direction;
import org.academiadecodigo.hexallents.lusozuca.position.EnemyPosition;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;

public class Enemy {
    private EnemyPosition pos;
    private Stage stage;
    private StageBackground color;
    private int moves = 0;
    private Direction lastDirection;


    public Enemy(int col, int row, Stage stage) {
        color = StageBackground.MAGENTA;
        pos = new EnemyPosition(col, row, stage);

    }

    public Position getPos(){
        return pos;
    }


    public void move(){



        //getPos().moveDirection(Direction.LEFT, (int) (Math.random() * 2));

        pos.moveDirection(Direction.RIGHT, (int) (Math.random() * 2));

    }

    /*private Direction generateNextDirection() {
        Direction nextDir;
        if (Math.random() > 0.2) {

            nextDir = getRandomDirection();
            lastDirection = nextDir;
        } else {
            nextDir = lastDirection;
        }

        return nextDir;
    }*/


}

