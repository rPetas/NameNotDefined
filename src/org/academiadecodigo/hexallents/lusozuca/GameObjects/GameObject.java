package org.academiadecodigo.hexallents.lusozuca.GameObjects;

import org.academiadecodigo.hexallents.lusozuca.position.Position;

/**
 * Created by codecadet on 14/02/2018.
 */
public abstract class GameObject {

    protected Position pos;

    public GameObject(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    public static enum Type {
        STAIR,
        PLATFORM,
        CHARACTER
    }
}
