public class DesignCircularQueue {
    class MyCircularQueue {
        //https://leetcode.com/problems/design-circular-queue/discuss/149420/Concise-Java-using-array
        //其实就是maintain两个指针，front and rear,front+1%len
        //One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
        //In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
        //But using the circular queue, we can use the space to store new values. 画图可以知道使用circular queue的好处
        //还有一种采用double linked list的做法，参见后面和MyJavaCode/DesignCircularQueueLinkedList
        //记住rear = (rear + 1) % a.length;
        final int[] a;
        int front, rear = -1, len = 0;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            a = new int[k];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                rear = (rear + 1) % a.length;
                a[rear] = value;
                len++;
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
                front = (front + 1) % a.length;
                len--;
                return true;
            }
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            return isEmpty() ? -1 : a[front];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            return isEmpty() ? -1 : a[rear];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return len == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return len == a.length;
        }
    }
}
