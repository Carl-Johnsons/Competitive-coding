public class Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
    }

    public static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            if ((num & 1) == 1) {
                num -= 1;
            } else {
                num >>>= 1;
            }
        }
        return count;
    }
}
