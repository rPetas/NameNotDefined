package org.academiadecodigo.hexallents.lusozuca.GameObjects;

import org.academiadecodigo.hexallents.lusozuca.characters.Player;
import org.academiadecodigo.hexallents.lusozuca.position.CharacterPosition;
import org.academiadecodigo.hexallents.lusozuca.position.PlatformPosition;
import org.academiadecodigo.hexallents.lusozuca.position.StairPosition;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;

public class GameObjectsFactory {

    public static GameObject getGameObject(GameObject.Type type, int col, int row) {
        switch (type) {
            case STAIR:
                StairPosition p = new StairPosition(col, row, 4);
                System.out.println(p);
                return new Stair(p);
            case PLATFORM:
                PlatformPosition pp = new PlatformPosition(col, row, 26);
                System.out.println(pp);
                return new Platform(pp);
        }
        throw new IllegalArgumentException("This factory cannot beep boop those objects");
    }

    public static Player getPlayer(int col, int row, Stage stage) {
        return new Player(new CharacterPosition(col, row, stage));
    }
}


