import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;//edge case, onsite可以不写
        helper(res, tmp, nums, 0);
        //本质是 dfs ,combination必须有一个 start 值被 传入
        res.add(new ArrayList<>());//最后加入一个空的arraylist
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);//没加上一次都可以成为一种res
            res.add(new ArrayList<>(tmp));
            helper(res, tmp, nums, i + 1);//与combination 类似，当前的i被加入后，只能加下面一个
            tmp.remove(tmp.size() - 1);//backtracking 的过程，让每一个元素都有被加入的机会
        }
    }
}//最经典的 permuation & combination model