public class WordSearch {
    // 参考 爱做饭
    // 这道题分析看，就是一个词，在一行出现也是true，一列出现也是true，一行往下拐弯也是true，一行往上拐弯也是true，一列往左拐弯也是true，一列往右拐弯也是true。所以是要考虑到所有可能性，基本思路是使用DFS来对一个起点字母上下左右搜索，看是不是含有给定的Word。还要维护一个visited数组，表示从当前这个元素是否已经被访问过了，过了这一轮visited要回false，因为对于下一个元素，当前这个元素也应该是可以被访问的。
    // 思路等同于 valid sudoku
    // 最经典的dfs
    // check每一个点 dsf 往往有backtracking 的过程

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];//visited数组建立在外面, 然后有一个backtracking的过程
        // dfs需要一个辅助记录 来保持访问的点不被再次访问
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j,
                       boolean[][] visited) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;// out of boundary
        if (board[i][j] != word.charAt(index))
            return false;// 位置不对
        if (visited[i][j])
            return false;// already visited
        visited[i][j] = true;
        boolean res = dfs(board, word, index + 1, i - 1, j, visited)
                || dfs(board, word, index + 1, i + 1, j, visited)
                || dfs(board, word, index + 1, i, j + 1, visited)
                || dfs(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;//backtracking process
        //onsite可以不写
//表示从当前这个元素是否已经被访问过了，过了这一轮visited要回false，因为对于下一个元素，当前这个元素也应该是可以被访问的。
        return res;
    }
}
