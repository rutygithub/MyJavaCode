import java.util.HashMap;
import java.util.Map;

    public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
        //y495711146's answer
        // Edge cases
        if (nums.length == 0) return 0;

        // Sliding window -- No, contains negative number
        // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for (int cur : nums) {
            sum += cur;
            if (map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                res += map.get(sum - k);
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        return res;
    }
}
