import javax.swing.tree.TreeNode;

public class CheckFullBinaryTree {
    //https://www.kanzhun.com/msh/g2084495-z388/?ka=interview-pos1#co_tab
    //interview question database for genshuixue，满二叉树的判断
    public boolean isBalanced(TreeNode root) {
        //https://leetcode.com/problems/balanced-binary-tree/
        //上面这道题目的变种，用recursion来算出tree的height
        if (root == null)
            return false;
        int val = helper(root);
        return val != -1;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1)
            return -1;
        if (left != right)
            return -1;
        int height = left + 1;
        return height;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
