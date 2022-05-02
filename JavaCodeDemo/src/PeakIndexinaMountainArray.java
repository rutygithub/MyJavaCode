public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        //https://leetcode.com/problems/peak-index-in-a-mountain-array/solution/
        //找到可能的点， solution解释的很清楚
        //while (lo < hi) 形式的binary search
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return hi;//return hi跟return lo一样，因为这样的binary search,最终lo和hi一致，跳出
    }
}
