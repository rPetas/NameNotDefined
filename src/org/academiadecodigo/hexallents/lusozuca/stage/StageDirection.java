package org.academiadecodigo.hexallents.lusozuca.stage;

/**
 * Created by codecadet on 17/02/2018.
 */
public enum StageDirection {

    LEFT,
    RIGHT;

    public boolean isOpposite(StageDirection dir) {
        return dir.equals(oppositeDirection());
    }

    public StageDirection oppositeDirection() {

        StageDirection opposite = null;

        switch (this) {
            case LEFT:
                opposite = StageDirection.RIGHT;
                break;
            case RIGHT:
                opposite = StageDirection.LEFT;
                break;
        }

        return opposite;
    }


}
