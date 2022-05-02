import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        //https://leetcode.com/problems/snakes-and-ladders/discuss/314202/Python3-clear-BFS-solution
        //https://leetcode.com/problems/snakes-and-ladders/discuss/214039/Clean-Java-Solution-BFS
        //onsite可以用point类,因为在方块里面做bfs可以考虑用point类  Set<Point> set = new HashSet<>();来进行标记，然后经典的bfs
        //这道题目现实中可以用自己的做法，了解下大概就好了，leetcode的做法有点复杂
        //onsite可以用MyJavaCode/SnakesAndLaddersMod,其实就是最经典的bfs, queue和set同步
        //remember to avoid circle by using a hashset to track visited positions
        //time complexity: O(n^2)
        //space complexity: O(n^2)
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }
        int rows = board.length;
        int cols = board[0].length;
        int dest = rows * cols;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == dest) {
                    return steps;
                }
                for (int diff = 1; diff <= 6 && curr + diff <= dest; diff++) {
                    int[] pos = getCoordinate(curr + diff, rows, cols);
                    int next = board[pos[0]][pos[1]] == -1 ? curr + diff : board[pos[0]][pos[1]];
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public int[] getCoordinate(int n, int rows, int cols) {
        int r = rows - 1 - (n - 1) / cols;
        int c = (n - 1) % cols;
        if (r % 2 == rows % 2) {
            return new int[]{r, cols - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}
