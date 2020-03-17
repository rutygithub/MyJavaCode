public class PopulatingNextRightPointersinEachNodeDFS {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        // https://discuss.leetcode.com/topic/6221/java-solution-with-o-1-memory-o-n-time/2
        // 这种是用recursion做DFS, 还有一种bfd的做法见github PopulatingNextRightPointersinEachNodeBFS 和后面
        if (root == null)
            return root;
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node node1, Node node2) {
        if (node1 == null || node2 == null)
            return;
        node1.next = node2;
        helper(node1.left, node1.right);
        helper(node1.right, node2.left);
        helper(node2.left, node2.right);
    }
}
