import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        //degree相当于准graph
        //https://leetcode.com/problems/alien-dictionary/discuss/70119/Java-AC-solution-using-BFS?page=5
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        StringBuffer res = new StringBuffer();
        if (words == null || words.length == 0)
            return res.toString();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(c1))
                        set = map.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                q.offer(c);
                res.append(c);
            }
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) {
                        q.offer(c2);
                        res.append(c2);
                    }
                }
            }
        }
        return res.length() != degree.size() ? "" : res.toString();
    }
}
