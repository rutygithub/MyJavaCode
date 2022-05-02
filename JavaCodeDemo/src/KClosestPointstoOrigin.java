import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        //根这道题目类似 closest用maxHeap，刚好相反。
        List<Point> list = new ArrayList<>();
        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);
            list.add(p);
        }//改成了用point class
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> (b.x * b.x + b.y * b.y - a.x * a.x - a.y * a.y));
        for (int i = 0; i < K; i++) {
            maxHeap.offer(list.get(i));
        }
        for (int i = K; i < list.size(); i++) {
            Point pt = list.get(i);
            Point top = maxHeap.peek();
            if (pt.x * pt.x + pt.y * pt.y < top.x * top.x + top.y * top.y) {
                maxHeap.poll();
                maxHeap.offer(pt);
            }
        }
        int[][] res = new int[K][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Point remainP = maxHeap.poll();
            res[index] = new int[]{
                    remainP.x, remainP.y
            };
            index++;
        }
        return res;
    }
}
