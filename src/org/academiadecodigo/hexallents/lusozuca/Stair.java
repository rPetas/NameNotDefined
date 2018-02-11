package org.academiadecodigo.hexallents.lusozuca;

import org.academiadecodigo.hexallents.lusozuca.stage.SimpleGfxColorMapper;
import org.academiadecodigo.hexallents.lusozuca.stage.Stage;
import org.academiadecodigo.hexallents.lusozuca.stage.StageBackground;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Stair {

    private Rectangle rectangle;
    private Position pos;
    private Stage stage;
    private StageBackground color;
    public static final int BLOCK_SIZE = 5;   //5 colunas ou linhas


    public Stair(int col, int row, Stage stage, int numberOfBlocks){
        pos = new Position(col, row, stage);
        rectangle = new Rectangle(stage.colToPixel(col), stage.rowToPixel(row), Stage.CELL_SIZE * BLOCK_SIZE, Stage.CELL_SIZE * BLOCK_SIZE * numberOfBlocks);
        rectangle.setColor(SimpleGfxColorMapper.getColor(StageBackground.GREEN));
        rectangle.fill();
        pos.show();
    }


}
