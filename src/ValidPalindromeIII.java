public class ValidPalindromeIII {
    public boolean validPalindrome(String s) {
        //一般能够想到的版本，ValidPalindromeII，就是leetcode有个test case过不了
        if (isValidPalindrome(s))
            return true;
        for (int i = 0; i < s.length(); i++) {
            StringBuffer sb = new StringBuffer(s);
            sb.deleteCharAt(i);
            if (isValidPalindrome(sb.toString()))
                return true;
        }
        return false;
    }

    private boolean isValidPalindrome(String s1) {
        int i = 0;
        int j = s1.length() - 1;
        while (i < j) {
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
