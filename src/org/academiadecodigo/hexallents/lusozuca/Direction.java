package org.academiadecodigo.hexallents.lusozuca;

/**
 * Created by codecadet on 11/02/2018.
 */
public enum Direction {

    UP,
    DOWN,
    LEFT,
    RIGHT;

    public Direction oppositeDirection(){

        Direction opposite=null;

        switch (this){
            case UP:
                opposite = Direction.DOWN;
                break;
            case DOWN:
                opposite = Direction.UP;
                break;
            case LEFT:
                opposite = Direction.RIGHT;
                break;
            case RIGHT:
                opposite = Direction.LEFT;
                break;
        }

        return opposite;
    }

}
