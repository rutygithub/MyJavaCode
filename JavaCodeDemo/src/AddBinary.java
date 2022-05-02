public class AddBinary {
    public String addBinary(String a, String b) {
        //https://leetcode.com/problems/add-strings/和 https://leetcode.com/problems/add-two-numbers/ 是一类题目 用同一种model
        //https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation
        //口诀就是carry%2, carry/2, 从后面开始
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
