public class Valid_Anagram {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        int alphabet[] = new int[26];
        for (char i : s.toCharArray()) {
            alphabet[i - 'a']++;
        }

        for (char i : t.toCharArray()) {
            if (alphabet[i - 'a'] == 0)
                return false;
            alphabet[i - 'a']--;
        }
        for (int i : alphabet) {
            if (i > 0)
                return false;
        }
        return true;
    }
}
