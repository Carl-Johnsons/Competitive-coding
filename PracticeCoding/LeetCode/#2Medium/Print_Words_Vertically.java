import java.util.LinkedList;
import java.util.List;

public class Print_Words_Vertically {
    public static void main(String[] args) {
        String s = "TO BE OR NOT TO BE";
        List<String> list = printVertically(s);
        for (String test : list) {
            System.out.print("\"" + test + "\"" + ",");
        }
    }

    public static List<String> printVertically(String s) {
        List<String> list = new LinkedList<>();
        String strs[] = s.split(" ");
        String verticalWord = "testing";
        String temp;
        int i = 0;
        while (!verticalWord.trim().isEmpty()) {
            verticalWord = "";
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    temp = " ";
                } else {
                    temp = strs[j].charAt(i) + "";
                }
                verticalWord += temp;
            }
            if (!verticalWord.trim().isEmpty()) {
                int k = verticalWord.length() - 1;
                while (verticalWord.charAt(k) == ' ') {
                    k--;
                }

                list.add(verticalWord.substring(0, k + 1));
            }
            i++;
        }
        return list;
    }
}