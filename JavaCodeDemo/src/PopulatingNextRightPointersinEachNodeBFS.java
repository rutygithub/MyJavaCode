import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeBFS {
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
        //II跟I的代码一模一样，但是II只能用BFS不能用DFS
        //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solution/
        //tree的bfs马上想到queue, graph里面的bfs马上想到queue和hashset
        if (root == null) {
            return root;
        }//edge case, onsite可以不写
        // Initialize a queue data structure
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (i < size - 1) {
                    //we wanna connect every nodes in the same level, except for the last node in the level
                    //如果要connect下一层的话，就不需要了
                    n.next = q.peek();
                }

                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
        }
        // Since the tree has now been modified, return the root node
        return root;
    }
}
