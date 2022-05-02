public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        //还有一种能够想到的版本，在后面和github里面, 面试的时候用能够想到的版本
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            }
        }
        return true;
    }

    private boolean isPalindrome(String str, int s, int t) {
        while (s <= t) {
            if (str.charAt(s) == str.charAt(t)) {
                s++;
                t--;
            } else
                return false;
        }

        return true;
    }
}
