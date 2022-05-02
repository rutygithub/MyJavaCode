public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //http://www.1point3acres.com/bbs/thread-425684-1-1.html
        //ms OTS 是这道题目的变种, 具体见microsoft/MaximumSubarray
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0)
                sum = 0;//面试的时候可以把这一段写在max = .....前面
        }
        return max;
    }
}// 维持两个变量 一个 sum几率局部，一个max记录所有，sum<0直接 归0，并且比较 sum和max 的大小
