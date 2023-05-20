public class Ransom_Note {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int ransomNoteHashTable[] = new int[26];
        int magazineHashTable[] = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteHashTable[(int) ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            magazineHashTable[(int) magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazineHashTable.length; i++) {
            if (ransomNoteHashTable[i] > magazineHashTable[i])
                return false;
        }
        return true;
    }
}
