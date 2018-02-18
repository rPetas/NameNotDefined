package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/02/2018.
 */
public class PlayerAnimation extends org.academiadecodigo.hexallents.lusozuca.position.Animation {

    public PlayerAnimation(CharacterPosition position) {
        super(position);

        animationUpDown = new Picture[4];
        animationLeft = new Picture[4];
        animationRight = new Picture[4];

        animationUpDown[0] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "back01.png");
        animationUpDown[1] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "back02.png");
        animationUpDown[2] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "back03.png");
        animationUpDown[3] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "back04.png");

        animationLeft[0] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "left01.png");
        animationLeft[1] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "left02.png");
        animationLeft[2] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "left03.png");
        animationLeft[3] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "left04.png");

        animationRight[0] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "right01.png");
        animationRight[1] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "right02.png");
        animationRight[2] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "right03.png");
        animationRight[3] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(), "right04.png");
    }

    /*public Picture animationUpAndDown(int index) {
        return animationUpDown[index];
    }*/

    public Picture animationLeft(int index) {
        return animationLeft[index];
    }

    public Picture animationRight(int index) {
        return animationRight[index];
    }


}

