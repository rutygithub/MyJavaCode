public class DesignCircularQueueLinkedList {
    //https://leetcode.com/problems/design-circular-queue/discuss/166325/Simple-Java-solution-using-Doubly-Linked-List
    class ListNode {
        int val;
        ListNode prev = null;
        ListNode next = null;

        public ListNode(int x) {
            val = x;
        }
    }

    class MyCircularQueue {
        int queueSize;
        int currSize;
        ListNode head, tail;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            queueSize = k;
            currSize = 0;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                ListNode newNode = new ListNode(value);
                ListNode p = tail.prev;
                newNode.next = tail;
                tail.prev = newNode;
                p.next = newNode;
                newNode.prev = p;
                currSize++;
                return true;
            }
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                ListNode n1 = head.next;
                ListNode n2 = head.next.next;
                head.next = n2;
                n2.prev = head;
                n1.next = null;
                n1.prev = null;//set the node to be deleted's prev and next pointer to null
                currSize--;
                return true;
            }
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return head.next.val;
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return tail.prev.val;
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return currSize == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return currSize == queueSize;
        }
    }
}
