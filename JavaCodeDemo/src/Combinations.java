import java.util.ArrayList;
import java.util.List;

public class Combinations {
    //参考 排列组合model 其实就是最经典的dfs model,
    //跟https://leetcode.com/problems/permutations/    permuation进行比较 permutation多了hashset作为辅助记录
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k)
            return res;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        helper(list, res, nums, k, 0);
        return res;
    }

    private void helper(List<Integer> list, List<List<Integer>> res, List<Integer> nums, int k, int index) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.size(); i++) {
            list.add(nums.get(i));
            helper(list, res, nums, k, i + 1);//注意这里是i+1,
            list.remove(list.size() - 1);//试想选了1以后，以后下一个只能丛2开始选，combination 需要有一个index 进行标记
        }
    }
}
