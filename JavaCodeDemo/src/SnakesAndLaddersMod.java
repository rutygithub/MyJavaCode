import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLaddersMod {

    public static int snakesAndLadders(int[][] board, Point start, Point end) {
        Queue<Point> q = new LinkedList<>();
        Set<Point> set = new HashSet<>();
        q.offer(start);
        set.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point pollPoint = q.poll();
                if (pollPoint.equals(end)) {
                    return step;
                }//poll出来point马上check 是否是destination
                int x = pollPoint.x;
                int y = pollPoint.y;
                for (int j = 1; j <= 6; j++) {
                    int nextY = y + j;
                    int nextX = x;
                    if (nextY >= board[0].length) {
                        nextY = nextY % board[0].length;//自己用一个test case搞定
                        nextX++;
                    }
                    if (nextX >= board.length)
                        continue;//out of board
                    Point next = new Point(nextX, nextY);
                    if (board[nextX][nextY] == -1 && !set.contains(next)) {
                        q.offer(next);
                        set.add(next);
                    }
                    if (board[nextX][nextY] != -1 && !set.contains(next)) {
                        set.add(next);
                        int laddder = board[nextX][nextY];
//                        q.offer(ladder)
//                          set.add(ladder)
                    }
                }


            }
        }
        return -1;
    }
}
