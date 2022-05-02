public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        //check palindrome 就是用经典的双指针，然后还有一种做法见后面
        String str = String.valueOf(x);
        //convert int to string
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
