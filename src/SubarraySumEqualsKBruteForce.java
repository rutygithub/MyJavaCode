public class SubarraySumEqualsKBruteForce {
    public int subarraySum(int[] nums, int k) {
        //本质上保持一个start和一个end指针，brute force的方法最好想到
        //https://leetcode.com/problems/subarray-sum-equals-k/solution/
        //Time complexity : O(n^2)
        //We need to consider every subarray possible.
        //Space complexity : O(1). Constant space is used.
        //不是brute force的做法见后面和 github/Myjavacode/SubarraySumEqualsK
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
