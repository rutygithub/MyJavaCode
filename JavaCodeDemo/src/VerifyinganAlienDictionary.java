import java.util.HashMap;
import java.util.Map;

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        //https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/209550/Java-HashMap-O(N-*-s.length())-4ms
        //https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/203246/Java-12-liner-w-comment-time%3A-O(mn)-space%3A-O(1).
        //就是建立一个hashmap把character的index存下来,以便知道先后顺序
        //跟alien dictionary 类似
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        } // construct mapping to the give order.
        for (int i = 1; i < words.length; i++) { // Verify the ajacent words order.
            String prev = words[i - 1];
            String cur = words[i];
            if (!compare(prev, cur, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String s, String t, Map<Character, Integer> map) { // compare the 2 words char by char.
        for (int i = 0; i < s.length() && i < t.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {//跟alien dic一样，找到第一个不同
                int a = map.get(s.charAt(i));
                int b = map.get(t.charAt(i));
                return a < b;//we get the sequence of the two string
            }
        }
        return s.length() < t.length(); // when one word is the prefix of the other, compare their sizes.
    }
}
