package org.academiadecodigo.hexallents.lusozuca.position;

import javafx.geometry.Pos;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 18/02/2018.
 */
public class Animation {

    protected Picture[] animationLeft;
    protected Picture[] animationRight;
    protected CharacterPosition characterPosition;

    public Animation (CharacterPosition position){
        this.characterPosition = position;
    }
}
