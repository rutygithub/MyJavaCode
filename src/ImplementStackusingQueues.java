import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    //https://leetcode.com/problems/implement-stack-using-queues/discuss/62516/Concise-1-Queue-Java-C%2B%2B-Python
    //https://leetcode.com/problems/implement-stack-using-queues/solution/
    //2个，loop一次，三个 loop两次。。。。。。把尾部的元素放在queue的头部, 只用一个queue来实现
    private Queue<Integer> queue = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
//    public MyStack() {
//
//    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++)
            queue.offer(queue.poll());
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
