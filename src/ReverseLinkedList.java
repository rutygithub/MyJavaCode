public class ReverseLinkedList {
    //https://leetcode.com/problems/reverse-linked-list/discuss/58156/My-Java-recursive-solution
    //https://leetcode.com/problems/reverse-linked-list/discuss/58337/Fast-Recursive-Java-solution
    //把recursion的部分看成一个整体 和一个节点, 然后推想,
    //从最初原始的base 开始一步步推出来
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
