import org.w3c.dom.Node;

public class InorderSuccessorinBSTII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node x) {
        //https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents
        //case 1 is where the node has a right child ( doesn't matter if the parent node exist of not), just find the successor.
        //case 2 the node has no right node, so successor might be in the parent, so just loop through the parent and find the first one bigger than x,
        if (x.right != null) {
            Node result = x.right;
            while (result.left != null) {
                result = result.left;
            }
            return result;
        } else {
            Node result = x.parent;
            while (result != null && result.val < x.val) {
                result = result.parent;
            }
            return result;
        }

    }
}
