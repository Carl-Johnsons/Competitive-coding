public class Minimum_Moves_to_Reach_Target_Score {
    public static void main(String[] args) {
        System.out.println(minMoves(32, 2));
    }

    public static int minMoves(int target, int maxDoubles) {
        if (maxDoubles == 0)
            return target - 1;
        int move = 0;
        while (target != 0 && maxDoubles != 0) {
            if ((target & 1) == 0) {
                target >>>= 1;
                maxDoubles--;
                move++;
            } else {
                target--;
                move++;
            }
        }
        move += (target - 1);
        return move;
    }
}
