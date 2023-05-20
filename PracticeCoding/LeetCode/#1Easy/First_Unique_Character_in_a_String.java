public class First_Unique_Character_in_a_String {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        int index = Integer.MAX_VALUE;
        int alphabet[] = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int value = (int) s.charAt(i) - 'a';
            if (alphabet[value] == -1) {
                alphabet[value] = i;
            } else {
                alphabet[value] = Integer.MIN_VALUE;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= 0) {
                if (index > alphabet[i])
                    index = alphabet[i];
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
