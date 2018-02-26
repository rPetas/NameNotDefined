package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/02/2018.
 */
public class PlayerAnimation extends Animation {

    public PlayerAnimation(CharacterPosition position) {
        super(position);

        animationLeft = new Picture[4];
        animationRight = new Picture[4];

        int x = characterPosition.representation.getX();
        int y = characterPosition.representation.getY();
        String path = "resources/sansImages/";

        for (int i = 0; i < animationLeft.length; i++) {
            animationLeft[i] = new Picture(x, y, path + "left0" + (i + 1) + ".png");
            animationRight[i] = new Picture(x, y, path + "right0" + (i + 1) + ".png");
        }
    }

    public Picture animationLeft(int index) {
        return animationLeft[index];
    }

    public Picture animationRight(int index) {
        return animationRight[index];
    }

}

