package org.academiadecodigo.hexallents.lusozuca.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/02/2018.
 */
public class PlayerAnimations {

    protected Picture[] playerPictures= new Picture[13];

    public PlayerAnimations (CharacterPosition characterPosition) {

        playerPictures[0] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"front01.png");
        playerPictures[1] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"back01.png");
        playerPictures[2] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"back02.png");
        playerPictures[3] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"back03.png");
        playerPictures[4] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"back04.png");
        playerPictures[5] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"left01.png");
        playerPictures[6] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"left02.png");
        playerPictures[7] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"left03.png");
        playerPictures[8] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"left04.png");
        playerPictures[9] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"right01.png");
        playerPictures[10] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"right02.png");
        playerPictures[11] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"right03.png");
        playerPictures[12] = new Picture(characterPosition.representation.getX(), characterPosition.representation.getY(),"right04.png");
    }

}
