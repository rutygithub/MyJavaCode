public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //https://leetcode.com/problems/same-tree/discuss/32687/Five-line-Java-solution-with-recursion   thefinestartist's answer
        //算法的时间复杂度是树的遍历O(n)
        //节点相等&&左子树相等&&右子树相等 才为真
        //symmetric tree, same tree, is subtree 都是同一个model
        //time and space complexity 参见https://leetcode.com/problems/same-tree/solution/, 特别注意space complexity
        if (p == null && q == null) return true;//base case for recursion
        if (p == null || q == null) return false;//base case for recursion, 2 base case for recursion
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
