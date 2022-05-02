public class RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //BST 马上想到 中序遍历,从小到大排列
//参考 http://huntfor.iteye.com/blog/2077665 和http://www.cnblogs.com/yuzhangcmu/p/4208319.html
//还有一种比较麻烦的做法,新建一个arraylist ,然后中序遍历 ,发现不对的值,在arraylist 里面 set 掉,然后通过这个修改后的arraylist 再新建一个tree.
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null;
    TreeNode second = null;//设置 prev first second 三个 pointer在外面十分巧妙

    public void recoverTree(TreeNode root) {
        //主要看 https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
        if (root == null)
            return;
        inorder(root);
        swap(first, second);
    }

    private void inorder(TreeNode root) {
        //prev 指针存的其实是该节点的直接前驱节点的值
        if (root == null)
            return;//base case for tree recursive
        inorder(root.left);
        //防止空指针的情况
        if (first == null && prev.val > root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}