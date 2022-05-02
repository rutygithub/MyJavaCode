import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        //https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205768/Java-easy-Level-Order-Traversal-one-while-loop
        //When level-order traversal in a complete tree,after we met the first null node, we can't meet any non-null node
        //Otherwise, the tree is not complete.
        //还是BFS level order offer, poll, offer的model
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }//meet the non-null node after we meet null node first, we need to return false
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return true;
    }
}
