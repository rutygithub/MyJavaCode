public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
    Node prev = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        //https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/discuss/149151/Concise-Java-solution-Beats-100
        //shawshawwan's answer 这样就可以不需要dummy了， 直接建立一个prev和head节点在外面就可以了
        //inorder tranversal by recursion to connect the original BST
        if (root == null) return null;//edge case, onsite可以不写
        helper(root);
        //connect head and tail
        prev.right = head;
        head.left = prev;//如果不是circular doubly linked list, 可以去掉这两句
        return head;
    }

    private void helper(Node cur) {
        if (cur == null) return;
        helper(cur.left);
        if (prev == null) {
            head = cur;
        }//which means reach the most left node, and cur node is the head of the doubly linked list
        else {
            prev.right = cur;
            cur.left = prev;
        }//in the other situation, just link the prev and cur
        prev = cur;
        helper(cur.right);
    }
}
