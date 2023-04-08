//https://leetcode.com/problems/optimal-partition-of-string/
public class Optimal_Partition_of_String {
    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        int minSubString = 1;
        int alphabet[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int k = (int) s.charAt(i) - 'a';
            if (alphabet[k] == 1) {
                alphabet = new int[26];
                minSubString++;
            }
            alphabet[k]++;

        }
        System.gc();
        return minSubString;
    }
}