public class PalindromeRemoval {
    //dp[i][j] means the min # of removals of subarray A[i,j]
    public int minimumMoves(int[] arr) {
        //这道题目有点难，本质上是 Longest Palindromic Substring的dp model
        //https://leetcode.com/problems/palindrome-removal/discuss/418881/C%2B%2B-O(N3)-13-lines-DP-with-explanation
        //https://leetcode.com/problems/palindrome-removal/discuss/442491/Java-O(N3)-DP-solution-where-dpij-means-the-min-of-removals-of-subarray-Aij
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            } else {
                dp[i][i + 1] = 2;
            }
        }

        for (int len = 3; len <= n; len++)
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];//把i+1, j-1的substring删除到剩下的一个character，然后前后链接起来刚好是palindrome
                } else {
                    // or, if we cannot remove arr[left] and arr[right] in one move (the last move),
                    // the subarray arr[left:right] must can be split into two subarrays
                    // and remove them one by one.
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }

        return dp[0][n - 1];
    }
}
