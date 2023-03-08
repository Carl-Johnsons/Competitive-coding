package pingpong;

import java.util.Random;

/**
 *
 * @author Nguyen Le Tai Duc CE170499 SE1705
 */
public class Randomizer {

    private static Random rand = new Random();

    public static int random(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
