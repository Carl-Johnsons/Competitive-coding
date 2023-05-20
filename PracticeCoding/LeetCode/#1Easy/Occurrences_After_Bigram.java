import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Occurrences_After_Bigram {
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student", first = "a", second = "good";
        System.out.println(Arrays.toString(findOcurrences(text, first, second)));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> third = new LinkedList<>();
        for (int i = 0; i < strs.length - 2; i++) {
            if (strs[i].equals(first)) {
                if (strs[i + 1].equals(second)) {
                    third.add(strs[i + 2]);
                }
            }
        }
        return third.toArray(new String[0]);
    }
}
