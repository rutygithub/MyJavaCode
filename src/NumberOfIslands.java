public class NumberOfIslands {
    class Solution {
        //union find solution for solving the Number of IslandsI problem.
        //https://leetcode.com/problems/number-of-islands/solutions/127691/number-of-islands/
        //refer video https://www.bilibili.com/video/BV1jv411a7LK/?spm_id_from=333.337.search-card.all.click&vd_source=18b4a07cf82a965169a35501b08d583e
        //https://www.youtube.com/watch?v=VJnUwsE4fWA
        int count; // # of connected components
        int[] parent;
        int[] rank;

        public void initUnionFind(char[][] grid) { // for problem 200
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
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

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            initUnionFind(grid);
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        grid[r][c] = '0';
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            union(r * nc + c, r * nc + c + 1);
                        }
                    }
                }
            }

            return count;
        }
    }
}
