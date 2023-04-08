//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1;
        // using booyer-moore to find the substring
        int BMT[] = new int[256];
        for (int i = 0; i < BMT.length; i++) {
            BMT[i] = -1;
        }

        for (int i = 0; i < needle.length(); i++) {
            BMT[(int) needle.charAt(i)] = i;
        }

        int i = 0;
        int j = needle.length() - 1;
        while (i + j < haystack.length()) {
            char k = haystack.charAt(i + j);
            char c = needle.charAt(j);

            if (k == c) {
                j--;
            }
            if (j == -1) {
                index = i;
                break;
            } else if (j >= 0 && k != c) {
                i += Math.max(j - BMT[(int) k], 1);
                j = needle.length() - 1;
            }
        }

        return index;
    }
}