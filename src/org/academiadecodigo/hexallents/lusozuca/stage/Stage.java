package org.academiadecodigo.hexallents.lusozuca.stage;

import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObject;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.GameObjectsFactory;
import org.academiadecodigo.hexallents.lusozuca.GameObjects.Platform;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Stage {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 5;
    private Rectangle rectangle;
    private int columns;
    private int rows;
    private GameObject[] gameObjects;

    public Stage(int cols, int rows) {
        this.columns = cols;
        this.rows = rows;

        rectangle = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        //Background white will be replaced by background image
        Color color = new Color(44, 219, 255);
        rectangle.setColor(color);
        rectangle.fill();
        // Background image replacing white background
        Picture backGroundPlatform = new Picture(Stage.PADDING, this.rows - Platform.BLOCK_SIZE, "resources/images/back_ground.png");
        backGroundPlatform.draw();

        gameObjects = new GameObject[10];
        //Platform
        gameObjects[0] = GameObjectsFactory.getGameObject(GameObject.Type.PLATFORM, 0, rows - 3);
        gameObjects[1] = GameObjectsFactory.getGameObject(GameObject.Type.PLATFORM, 14 * 5, 15 * 5);
        gameObjects[2] = GameObjectsFactory.getGameObject(GameObject.Type.PLATFORM, 0, 11 * 5);
        gameObjects[3] = GameObjectsFactory.getGameObject(GameObject.Type.PLATFORM, 14 * 5, 7 * 5);
        gameObjects[4] = GameObjectsFactory.getGameObject(GameObject.Type.PLATFORM, 0, 3 * 5);

        gameObjects[5] = GameObjectsFactory.getGameObject(GameObject.Type.STAIR, 23 * 5, 15 * 5);
        gameObjects[6] = GameObjectsFactory.getGameObject(GameObject.Type.STAIR, 16 * 5, 11 * 5);
        gameObjects[7] = GameObjectsFactory.getGameObject(GameObject.Type.STAIR, 23 * 5, 7 * 5);
        gameObjects[8] = GameObjectsFactory.getGameObject(GameObject.Type.STAIR, 16 * 5, 3 * 5);
        gameObjects[9] = GameObjectsFactory.getGameObject(GameObject.Type.STAIR, 23 * 5, -5);

        // quantidade de linhas do stage - tamanho do bloco em linhas (não em pixels)
        //Stairs

        //Criação das plataformas: imagens

        Picture picPlatform1 = new Picture(10, rowToPixel(getRows() - 20), "resources/images/first_step.png");
        picPlatform1.draw();
        System.out.println(picPlatform1.toString());
        Picture picPlatform2 = new Picture(314, rowToPixel(getRows() - 32), "resources/images/cloud.png");
        picPlatform2.draw();
        System.out.println(picPlatform2.toString());
        Picture picPlatform3 = new Picture(10, rowToPixel(getRows() - 53), "resources/images/cloud.png");
        picPlatform3.draw();
        System.out.println(picPlatform3.toString());
        Picture picPlatform4 = new Picture(314, rowToPixel(getRows() - 72), "resources/images/cloud.png");
        picPlatform4.draw();
        System.out.println(picPlatform4.toString());
        Picture picPlatform5 = new Picture(10, rowToPixel(getRows() - 93), "resources/images/cloud.png");
        picPlatform5.draw();
        System.out.println(picPlatform5.toString());
    }

    public static int colToPixel(int column) {
        return column * CELL_SIZE + PADDING;
    }

    public static int rowToPixel(int row) {
        return row * CELL_SIZE + PADDING;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getWidth() {
        return columns * CELL_SIZE;
    }

    public int getHeight() {
        return rows * CELL_SIZE;
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public GameObject[] getGameObjects() {
        return gameObjects;
    }
}