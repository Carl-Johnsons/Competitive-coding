public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String str[] = new String[] { "a", "ab" };
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String res = "";

        int i = 0;
        boolean wrong = false;
        while (!wrong) {
            if (strs[0].isEmpty()) {
                wrong = true;
                break;
            }
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && i < strs[0].length()) {
                    if (strs[0].charAt(i) != strs[j].charAt(i)) {
                        wrong = true;
                        break;
                    }
                } else {
                    wrong = true;
                    break;
                }
                if (strs[j].isEmpty()) {
                    wrong = true;
                    break;
                }
            }
            if (wrong)
                break;
            i++;
        }
        res = strs[0].substring(0, i);
        return res;
    }
}
