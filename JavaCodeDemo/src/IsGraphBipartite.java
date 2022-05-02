import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] g) {
        //onsite写的时候可以把接口改成list, 然后用一个color做辅助记录，bfs
        /*Our goal is trying to use two colors to color the graph and see if there are any adjacent nodes having the same color.
          Initialize a color[] array for each node. Here are three states for colors[] array:
          0: Haven't been colored yet.
          1: Blue.
          -1: Red.
          For each node,
          If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
          If it has been colored, check if the current color is the same as the color that is going to be used to color it. (Please forgive my english... Hope you can understand it.)*/
        //https://leetcode.com/problems/is-graph-bipartite/discuss/120218/Java-Short-Iterative-Solution
        //https://leetcode.com/problems/is-graph-bipartite/discuss/115487/Java-Clean-DFS-solution-with-Explanation
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    for (int adjacent : g[node])
                        if (colors[adjacent] == colors[node])
                            return false;
                        else if (colors[adjacent] == 0) {
                            q.offer(adjacent);
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        return true;
    }
}
