import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    // 参考code ganker和爱做饭,具体解释见eclipse
    //https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-%2B-HashMap
    public String minWindow(String s, String t) {
        //对短的substring做frequency table, 然后建立left, count, minLen, minStart，先移动右指正，后移动左指针来做
        if (s == null || s.length() == 0)
            return "";// onsite可以不写
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        int left = 0;
        int count = 0;
        int minLen = s.length() + 1;
        int minStart = 0;
        // two pointer 标准model 用left 表示左指针,right表示右指针,用for loop
        //通过 起始位和长度来确定一个substring,思想同 longest palindrome substring
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {//onsite的时候此条件可以不写
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {//onsite的时候此条件可以不写
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(minStart, minStart + minLen);
        // onsite可以不写 minLen> S.length()? "":
    }
}
