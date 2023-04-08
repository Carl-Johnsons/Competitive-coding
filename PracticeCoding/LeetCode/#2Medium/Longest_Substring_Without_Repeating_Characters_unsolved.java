//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Longest_Substring_Without_Repeating_Characters_unsolved {
    public static void main(String[] args) {
        String s = "bbtablud";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int LongestSubString = 0;
        int lastOccurence[] = new int[256];
        for (int i = 0; i < lastOccurence.length; i++) {
            lastOccurence[i] = -1;
        }
        int a = 0;
        for (int i = 0; (i + a) < s.length(); a++) {
            int currentIndex = i + a;
            int k = (int) s.charAt(currentIndex);
            if (lastOccurence[k] != -1) {
                if (max < LongestSubString) {
                    max = LongestSubString;
                }
                // char test = (char) k;
                LongestSubString = currentIndex - lastOccurence[k];
                i += Math.max(i + (currentIndex - (currentIndex - lastOccurence[k])), 1);
                a = LongestSubString - 1;

                for (int j = 0; j < lastOccurence.length; j++) {
                    lastOccurence[j] = -1;
                }
                int temp = 0;
                int j = (i + a);
                if (j >= 0 && j < s.length())
                    temp = (int) s.charAt(j);
                while (j < s.length() && j >= 0) {

                    lastOccurence[temp] = j;
                    if (j == i) {
                        break;
                    }
                    j--;

                    temp = (int) s.charAt(j);

                }
            } else {
                lastOccurence[k] = currentIndex;
                LongestSubString++;
            }
        }
        if (max < LongestSubString) {
            max = LongestSubString;
        }
        System.gc();
        return max;
    }
}
