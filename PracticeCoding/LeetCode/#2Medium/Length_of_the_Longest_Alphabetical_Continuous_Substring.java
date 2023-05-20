public class Length_of_the_Longest_Alphabetical_Continuous_Substring {
    public static void main(String[] args) {
        String s = "ababcababcd";
        System.out.println(longestContinuousSubstring(s));
    }

    public static int longestContinuousSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int i = 0, j = 0, max = 0;
        char c, str[] = s.toCharArray();
        while (i + j < str.length) {
            c = str[i + j];
            while (i + j < str.length && str[i + j] == c++) {
                j++;
            }
            if (max < j)
                max = j;
            i += j;
            j = 0;
        }
        return max;
    }
}
