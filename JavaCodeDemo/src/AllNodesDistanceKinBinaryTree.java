import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143752/JAVA-Graph-%2B-BFS
        //use hashet in BFS to avoid revisit the same node that has been visited before
        //do BFS with source vertice (target) to find all vertices with distance K to it.
        //distance K 一看就知道离target K 步，所以用BFS来做比较省力
        //如果有parent指针的话，就不需要hashmap找parent
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        //here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, key is child, value is parent
        buildMap(root, null, map);

        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        set.add(target);
        int dist = 0;

        while (!q.isEmpty()) {
            if (dist == K) {
                while (!q.isEmpty()) res.add(q.poll().val);
                return res;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null && !set.contains(cur.left)) {
                    q.offer(cur.left);
                    set.add(cur.left);
                }
                if (cur.right != null && !set.contains(cur.right)) {
                    q.offer(cur.right);
                    set.add(cur.right);
                }
                if (map.get(cur) != null && !set.contains(map.get(cur))) {
                    q.offer(map.get(cur));
                    set.add(map.get(cur));
                }
            }
            dist++;

        }
        return res;
    }

    public void buildMap(TreeNode node, TreeNode parent, Map map) {
        if (node == null) return;//base case for recursion

        map.put(node, parent);
        buildMap(node.left, node, map);
        buildMap(node.right, node, map);
    }
}
