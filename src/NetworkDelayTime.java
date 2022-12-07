import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //https://leetcode.com/problems/network-delay-time/discuss/248390/Shortest-Path-Faster-Algorithm-(SPFA)-26ms-beats-86.85
        //Shortest Path Faster Algorithm (SPFA)
        //SPFA is an improvement on top of Bellman-Ford, and prabably easier to understand than Dijkstra. It is popular with students who take part in NOIP and ACM-ICPC. The key points are
        //We use a FIFO queue to store vertices that are about to be relaxed.
        //Vertices should be reinserted into the queue whenever its distance is updated.
        //The worst-case running time of the algorithm is O(|V|*|E|)} O(|V|*|E|) , just like the standard Bellman-Ford algorithm.
        //BFS  + relaxation
        //wiki上中文的最短路径快速算法解释的很好
        // construct the graph
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        for (int[] e : times) {
            costs.putIfAbsent(e[0], new HashMap<Integer, Integer>());
            costs.get(e[0]).put(e[1], e[2]);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k] = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] inQue = new boolean[n + 1]; // indicate whether the element is inside the queue or not
        q.offer(k);
        while (!q.isEmpty()) {
            int node = q.poll();
            inQue[node] = false;
            if (costs.containsKey(node)) {
                for (int neighbor : costs.get(node).keySet()) {
                    int d = costs.get(node).get(neighbor);
                    if (distances[neighbor] > distances[node] + d) {
                        //find the node could be relaxed.
                        distances[neighbor] = distances[node] + d;
                        if (!inQue[neighbor]) {
                            q.offer(neighbor);
                            inQue[neighbor] = true;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, distances[i]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
