public class BinaryTreeColoringGame {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int left, right, val;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        //https://leetcode.com/problems/binary-tree-coloring-game/discuss/350570/JavaC%2B%2BPython-Simple-recursion-and-Follow-Up
        //https://leetcode.com/problems/binary-tree-coloring-game/discuss/350738/Easy-to-understand-for-everyone
        //https://www.cnblogs.com/Asurudo/p/11298007.html
        //microsoft面试 面到的概率不是特别大，可以忽略此题
        val = x;
        //count the node in the subtree which has the root's value x
        count(root);
        // if player2 chooses player1's parent node and payer1 node's count is smaller than n/2, player2 will win
        //for the equal case, if the n is 11, n/2 =5,if left+right+1=5,thus the player2 will win the game if he choose player1's parent node
        if (left + right + 1 <= n / 2) return true;
        // if player2 chooses player1's left or right node and its count is bigger than n/2, player2 will win
        if (left > n / 2 || right > n / 2) return true;
        else return false;
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        int l = count(node.left);
        int r = count(node.right);
        if (node.val == val) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}
