public class SubtreeofAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //https://github.com/rutygithub/workspace/blob/master/workspace/Amazon/src/SubTree.java
        //口诀: is subtree 最后要转成is same tree 然后把左右子树劈开
        //https://www.cnblogs.com/grandyang/p/6828687.html
        //https://leetcode.com/problems/subtree-of-another-tree/discuss/188626/Java-traversal-Shortest-method-4-lines
        //https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal
        //一看到subtree 马上想到same tree的代码
        //亚马逊高频题，必看
        //symmetric tree, same tree, is subtree 都是同一个model
        if (s == null) return false;//没办法避开了， return false
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null) return false;
        if (s.val != t.val)
            return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
