import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Reorganize_String {
    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        Map<Character, Integer> occureneces = new HashMap<>();
        Queue<OccurenceOfChar> q = new PriorityQueue<>((a, b) -> b.occur - a.occur);
        for (int i = 0; i < s.length(); i++) {
            occureneces.merge(s.charAt(i), 1, Integer::sum);
        }
        for (Character i : occureneces.keySet()) {
            q.add(new OccurenceOfChar(i, occureneces.get(i)));
        }
        OccurenceOfChar a, b;
        while (!q.isEmpty()) {
            a = q.poll();
            b = q.poll();
            if (b == null) {
                if (a != null) {
                    if (a.occur > 1 ||
                            (res.length() - 1 >= 0 && a.c == res.charAt(res.length() - 1))) {
                        return "";
                    }
                    res += a.c;
                }
                break;
            }
            res += a.c;
            res += b.c;
            a.occur--;
            b.occur--;

            if (a.occur > 0)
                q.add(a);
            if (b.occur > 0)
                q.add(b);
        }
        return res;
    }

    static class OccurenceOfChar {
        char c;
        int occur;

        public OccurenceOfChar(char c, int occur) {
            this.c = c;
            this.occur = occur;
        }
    }
}
