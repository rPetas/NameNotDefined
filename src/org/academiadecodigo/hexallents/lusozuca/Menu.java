package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {

    private Picture picture;

    public Menu(String path) {
        picture = new Picture(Stage.PADDING, Stage.PADDING, path);
        draw();
    }

    public void draw() {
        picture.draw();
    }

    public void delete() {
        picture.delete();
    }
}
