public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        //节点相等&&p左子树等于q右子树&&右子树等于q左子树 才为真
        //参考 https://leetcode.com/problems/symmetric-tree/solution/
        //https://leetcode.com/problems/symmetric-tree/discuss/33104/1ms-recursive-Java-Solution-easy-to-understand
        //symmetric tree, same tree, is subtree 都是同一个model
        //Time complexity : O(n)O(n). Because we traverse the entire input tree once, the total run time is O(n), where n is the total number of nodes in the tree.
        //Space complexity : The number of recursive calls is bound by the height of the tree.
        // In the worst case, the tree is linear and the height is in O(n). Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
        //https://leetcode.com/problems/symmetric-tree/solution/
        if (root == null) return true;//edge case, onsite可以不写
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (q == null && p != null)) return false;
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}
