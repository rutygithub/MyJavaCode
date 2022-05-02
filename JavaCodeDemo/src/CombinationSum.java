import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            //就是最经典的permuation & combination model
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            if (candidates == null || candidates.length == 0 || target == 0)
                return res;//edge case, onsite 可以不写
            helper(list, res, candidates, target, 0, 0);//combination 需要有 index 作为变量，permutation 需要visisted 作为辅助记录
            return res;
        }

        private void helper(List<Integer> list, List<List<Integer>> res, int[] candidates, int target, int sum, int index) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
                return;
            }
            if (sum > target)
                return;
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                helper(list, res, candidates, target, sum + candidates[i], i);//combination 其实就是一个dfs,一直往下走
                list.remove(list.size() - 1);//backtracking process
            }
        }
    }
}
