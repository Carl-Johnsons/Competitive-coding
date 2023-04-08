public class Check_if_Numbers_Are_Ascending_in_a_Sentence {
    public static void main(String[] args) {
        String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
        System.out.println(areNumbersAscending(s));
    }

    public static boolean areNumbersAscending(String s) {
        int length = s.length();
        int j = -1, current = 0, temp;
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                j = i;
                i++;
                while (i < length && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                temp = Integer.parseInt(s.substring(j, i));
                if (current < temp) {
                    current = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
