import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        //标准的merge sort 算法，参考workspace/classicalAlgorithm/src/classicalAlgorithm/mergeSort2.java 并做了近一步的改进
        int array[] = {32, 12, 7, 78, 23, 45};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        //通过arrays.toString来输出string 很漂亮
    }

    public static int[] mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            int[] left = mergeSort(arr, low, mid);
            int[] right = mergeSort(arr, mid + 1, high);
            return mergeTwoSortedArray(left, right);
        }
        return arr;
    }


    public static int[] mergeTwoSortedArray(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j])
                C[k++] = A[i++];
            else
                C[k++] = B[j++];
        }
        while (i < A.length)
            C[k++] = A[i++];
        while (j < B.length)
            C[k++] = B[j++];
        return C;
    }
}
