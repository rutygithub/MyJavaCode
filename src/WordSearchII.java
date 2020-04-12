import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        //还是采用word search I 的做法， 只不过现在变成了string array了，用hashset来确定result string的唯一性，然后再倒到arraylist里面，onsite可以直接用返回arraylist，不需要hashset
        Set<String> set = new HashSet<>();
        for (int k = 0; k < words.length; k++) {
            String s = words[k];
            boolean[][] visited = new boolean[board.length][board[0].length];// 把boolean map 放在外面
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, s, visited, 0)) {
                        set.add(s);
                        break;
                    }
                }
        }
        List<String> res = new ArrayList<>(set);
        return res;
    }

    public boolean dfs(char[][] board, int i, int j, String word,
                       boolean[][] visited, int start) {
        if (start == word.length()) {
            return true;// find one successful occurrence
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;// out of boundary
        }
        if (word.charAt(start) != board[i][j]) {
            return false;// wrong position
        }
        if (visited[i][j]) {
            return false;// already visited
        }

        visited[i][j] = true;// mark

        boolean flag = dfs(board, i + 1, j, word, visited, start + 1)
                || dfs(board, i - 1, j, word, visited, start + 1)
                || dfs(board, i, j + 1, word, visited, start + 1)
                || dfs(board, i, j - 1, word, visited, start + 1);
        visited[i][j] = false;// backtracking process, for the next
        return flag;
    }
}
