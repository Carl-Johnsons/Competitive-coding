import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String s = "cbbbcc";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), s, 0);
        return list;
    }

    public static void backTracking(
            List<List<String>> list,
            List<String> tempList,
            String s,
            int start) {
        int len = s.length();
        if (start == len) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        String temp;
        for (int i = 1; start + i <= len; i++) {
            temp = s.substring(start, start + i);
            if (isPalindrome(temp.toCharArray())) {
                tempList.add(temp);
                backTracking(list, tempList, s, start + i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(char str[]) {
        if (str.length == 1)
            return true;
        int i = 0, j = str.length - 1;
        while (i < j) {
            if (str[i] != str[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
