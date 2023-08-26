
//https://codeforces.com/problemset/problem/1722/C

import java.util.*;

public class Word_Game {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int n = sc.nextInt(); // number of words
        // read in the words for each player
        String[] p1 = new String[n];
        String[] p2 = new String[n];
        String[] p3 = new String[n];
        for (int i = 0; i < n; i++) {
            p1[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            p2[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            p3[i] = sc.next();
        }
        // calculate the points for each player
        int[] points = new int[3];
        Set<String> set1 = new HashSet<>(Arrays.asList(p1));
        Set<String> set2 = new HashSet<>(Arrays.asList(p2));
        Set<String> set3 = new HashSet<>(Arrays.asList(p3));
        // check words written by one person
        for (String word : set1) {
            if (!set2.contains(word) && !set3.contains(word)) {
                points[0] += 3;
            }
        }
        for (String word : set2) {
            if (!set1.contains(word) && !set3.contains(word)) {
                points[1] += 3;
            }
        }
        for (String word : set3) {
            if (!set1.contains(word) && !set2.contains(word)) {
                points[2] += 3;
            }
        }
        // check words written by two people
        for (String word : set1) {
            if (set2.contains(word) && !set3.contains(word)) {
                points[0]++;
                points[1]++;
            } else if (set3.contains(word) && !set2.contains(word)) {
                points[0]++;
                points[2]++;
            }
        }
        for (String word : set2) {
            if (set3.contains(word) && !set1.contains(word)) {
                points[1]++;
                points[2]++;
            }
        }
        // output the points
        System.out.println(points[0] + " " + points[1] + " " + points[2]);
    }
}