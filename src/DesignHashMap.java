public class DesignHashMap {
    //this problem is using separate chain method to solve the collision for hashing,
    //another is called （linear probing)open addressing
    //https://leetcode.com/problems/design-hashmap/discuss/152746/Java-Solution + neildawg's answer
    //每次操作前先算出getIndex和fin prev node找到前面那个节点,dummy variable
    final ListNode[] nodes = new ListNode[1000];//1000 is best for the runing time and memory usage performance

    public void put(int key, int value) {
        int index = getIndex(key);
        if (nodes[index] == null) {
            nodes[index] = new ListNode(-1, -1);//dummy varialbe for linked list
            //不做dummy的话，remove就有问题了
        }
        ListNode prev = findPrev(nodes[index], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get(int key) {
        int index = getIndex(key);
        if (nodes[index] == null)
            return -1;
        ListNode node = findPrev(nodes[index], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (nodes[index] == null) return;
        ListNode prev = findPrev(nodes[index], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    int getIndex(int key) {
        return key % nodes.length;
    }

    ListNode findPrev(ListNode start, int key) {//find the previous node for the specific key
        ListNode p = start;
        ListNode prev = null;
        while (p != null && p.key != key) {
            prev = p;
            p = p.next;
        }
        return prev;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
