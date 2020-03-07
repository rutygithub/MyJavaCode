public class InorderSuccessorinBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 还有一种简单的方法见https://leetcode.com/problems/inorder-successor-in-bst/discuss/72662/*Java*-5ms-short-code-with-explanations
        // 面试建议用这种 但是上面那种看看思路很好
        //分成p.right == null 和!= null 两种情况， 然后看看root 是否能成为successor, 一步步逼近p
        //建议这种方法不看，看有parent 指针的 https://leetcode.com/problems/inorder-successor-in-bst-ii/
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            TreeNode successor = null;// 其实可以TreeNode successor
            while (root != null) {
                if (root.val > p.val) {
                    //In this case, root can be a possible answer, so we store the root node first and call it successor.
                    //However, we don't know if there is anymore node on root's left that is larger than p.val.
                    //So we move root to its left and check again.
                    successor = root;
                    root = root.left;
                } else if (root.val < p.val) {//root can't be the successor
                    root = root.right;
                } else {
                    break; // which means p.val == root.val
                }
            }
            return successor;
        }
    }
}
