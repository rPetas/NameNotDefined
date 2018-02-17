package org.academiadecodigo.hexallents.lusozuca.stage;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class SimpleGfxColorMapper {

    private static final Color colors[] = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.MAGENTA,
            Color.WHITE,
            Color.BLACK,
            Color.CYAN
    };

    public static Color getColor(StageBackground color){

        Color sGfxColor = null;

        switch (color) {
            case RED:
                sGfxColor = colors[0];
                break;
            case GREEN:
                sGfxColor = colors[1];
                break;
            case BLUE:
                sGfxColor = colors[2];
                break;
            case MAGENTA:
                sGfxColor = colors[3];
                break;
            case NOCOLOR:
                sGfxColor = colors[4];
                break;
            case CYAN:
                sGfxColor = colors[5];
                break;
            default:
                System.out.println("something went terribly wrong...");
        }

        return sGfxColor;
    }
}
