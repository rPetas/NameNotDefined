package org.academiadecodigo.hexallents.lusozuca.characters;

import org.academiadecodigo.hexallents.lusozuca.position.EnemyPosition;
import org.academiadecodigo.hexallents.lusozuca.position.Position;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.hexallents.lusozuca.stage.StageDirection;

public class Enemy {
    private Position pos;
    private Stage stage;
    private StageBackground color;
    private int moves = 0;
    protected StageDirection currentDirection;
    private int directionChangeLevel = 8; // randomness of direction changes from 1 to 10


    public Enemy(int col, int row, Stage stage) {
        pos = new EnemyPosition(col, row, stage);
        color = StageBackground.LIGHT_GRAY;

    }

    public StageDirection chooseDirection() {

        // Let's move in the same direction by default
        StageDirection newDirection = currentDirection;

        // Sometimes, we want to change direction...
        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = StageDirection.values()[(int) (Math.random() * StageDirection.values().length)];

            // but we do not want to perform U turns..
            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }
        }

        return newDirection;

    }


    public void move() {
        moves++;

    }


}

