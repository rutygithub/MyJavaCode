import java.util.Arrays;

public class QuickSort {
    //offer书 p.173 代码在offer书 P.174
    public static void main(String[] args) {
        int array[] = {32, 12, 7, 78, 23, 45};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        //通过arrays.toString来输出string 很漂亮
    }

    public static void quickSort(int[] A, int low, int high) {
        int start = low;
        int end = high;
        int key = A[low];
        while (start < end) {
            while (start < end && A[end] >= key) {//都是跟key大小进行比较
                end--;
            }
            if (A[end] <= key) {
                swap(A, start, end);
            }

            while (start < end && A[start] <= key) {//都是跟key大小进行比较
                start++;
            }

            if (A[start] >= key) {
                swap(A, start, end);
            }
        }

        if (start > low)
            quickSort(A, low, start - 1);
        if (end < high)
            quickSort(A, end + 1, high);
    }

    private static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
