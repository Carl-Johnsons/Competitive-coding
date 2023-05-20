public class Reverse_Words_in_a_String {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String strs[] = s.trim().split("[ ]+");
        int i = 0, j = strs.length - 1;
        String temp;
        while (i < j) {
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;

            i++;
            j--;
        }
        return String.join(" ", strs);
    }
}