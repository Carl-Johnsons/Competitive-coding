package Game;

import java.awt.AWTException;

public class Game extends TicTacToeGame {

    public Game() throws AWTException {
        super();
    }

    public static void main(String[] args) throws AWTException, InterruptedException {
        Game a = new Game();
        a.GameSystem();
    }

}
