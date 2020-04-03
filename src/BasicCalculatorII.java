import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        //https://leetcode.com/problems/basic-calculator-ii/discuss/63003/Share-my-java-solution
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        //edge case
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (lastSign == '-') {
                    stack.push(-num);
                }
                if (lastSign == '+') {
                    stack.push(num);
                }
                if (lastSign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (lastSign == '/') {
                    stack.push(stack.pop() / num);
                }
                lastSign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
