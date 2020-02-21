import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        //refer http://www.jiuzhang.com/solutions/letter-combinations-of-a-phone-number/
        List<String> result = new ArrayList<>();

        if (digits == null || digits.equals("")) {
            return result;
        }// onsite可以不写

        Map<Character, char[]> map = new HashMap<>();// hashmap char mapping char array
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, result, 0);

        return result;
    }

    private void helper(Map<Character, char[]> map, String digits,
                        StringBuilder sb, List<String> result, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c : map.get(digits.charAt(index))) {//记住enhanced for loop
            sb.append(c);
            helper(map, digits, sb, result, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
