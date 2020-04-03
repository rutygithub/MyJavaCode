public class DiameterofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        //https://leetcode.com/problems/binary-tree-maximum-path-sum/  类似的Model
        //https://leetcode.com/problems/diameter-of-binary-tree/solution/
        if (root == null)
            return 0;//edge case
        depth(root);
        return max - 1;
    }

    int max;

    public int depth(TreeNode node) {
        if (node == null) return 0;
        //base case for recursion
        int left = depth(node.left);
        int right = depth(node.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
