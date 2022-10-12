import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    //https://leetcode.com/problems/number-of-islands-ii/solution/
    //union find, the solution is related with number of island union find solution
    //只能用把二维数组转成一维数组的办法
    //https://leetcode.com/problems/number-of-islands-ii/discuss/75470/Easiest-Java-Solution-with-Explanations?page=1
    //比较 https://leetcode.com/problems/redundant-connection/description/
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public void initUnionFind(int m, int n) { // for problem 305 and others
        count = 0;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m * n; ++i) {
            parent[i] = -1;
            rank[i] = 0;
        }
    }

    public void setParent(int i) {
        if (parent[i] == -1) {
            parent[i] = i;
            ++count;
        }
    }

    public int find(int i) { //find the root for the root i and do the path compression while the finding process
        if (parent[i] == i) {
            return i;//or     return parent[i]; the same
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }

    public void union(int x, int y) { // union with rank
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        initUnionFind(m, n);

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int index = r * n + c;
            setParent(index);

            if (r - 1 >= 0 && parent[(r - 1) * n + c] >= 0) union((r - 1) * n + c, index);
            if (r + 1 < m && parent[(r + 1) * n + c] >= 0) union((r + 1) * n + c, index);
            if (c - 1 >= 0 && parent[r * n + (c - 1)] >= 0) union(r * n + (c - 1), index);
            if (c + 1 < n && parent[r * n + (c + 1)] >= 0) union(r * n + (c + 1), index);

            res.add(count);
        }

        return res;
    }
}
