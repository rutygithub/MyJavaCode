import java.util.*;

public class MeetingRoomsII {
    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        //https://leetcode.com/problems/meeting-rooms-ii/discuss/67857/AC-Java-solution-using-min-heap chrislzm's answer
        // 微软ots不要用lambda expression, 就用上面那个版本
        //uses min heap, average time complexity is O(nlogn).
        // 口诀:interval根据start排序，heap根据end排序, initial set, return heap size
        // compare the interval's end time in the pq with the start time of next meeting
        //https://leetcode.com/problems/meeting-rooms-ii/discuss/67857/AC-Java-solution-using-min-heap
        if (intervals == null || intervals.length == 0) return 0;//onsite可以不写
        List<Interval> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            list.add(new Interval(start, end));
        }//前面就是把input变成list of intervals
        Collections.sort(list, (a, b) -> a.start - b.start);
        // Sort the intervals by start time
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        // lambda expression for sort by comparator
        // Use a min heap to track the minimum end time of merged intervals
        minHeap.offer(list.get(0));
        // start with the first meeting, put it to a meeting room
        for (int i = 1; i < list.size(); i++) {
            if (minHeap.peek().end > list.get(i).start) {
                //this meeting needs a new room
                minHeap.offer(list.get(i));
            } else {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                Interval pollInterval = minHeap.poll();
                pollInterval.end = list.get(i).end;
                minHeap.offer(pollInterval);
            }
        }
        return minHeap.size();
    }
}
