import org.academiadecodigo.hexallents.lusozuca.Game;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

/**
 * Created by codecadet on 18/02/2018.
 */
public class Menu implements KeyboardHandler{

    private Game game;
    private Picture menuScreen;
    private Keyboard menuKeyboard;

    public Menu (Game game, Stage stage){
        this.game = game;
        menuScreen = new Picture(stage.getX(), stage.getY(), "/resources/otherScreens/bg_game.png");
        menuKeyboard = new Keyboard(this);

        KeyboardEvent start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_S);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        menuKeyboard.addEventListener(start);
        menuKeyboard.addEventListener(quit);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey()==KeyboardEvent.KEY_S){
            try {
                game.start();
            } catch (InterruptedException ex){
                System.out.println("Something went wrong : MENU");
            }
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
