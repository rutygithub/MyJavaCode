import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //offer书 P.170
        int array[] = {32, 12, 7, 78, 23, 45};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        //通过arrays.toString来输出string 很漂亮
        List<Integer> list = Arrays.asList(array);
        System.out.println(list);
    }

    public static int[] bubbleSort(int[] A) {
        if (A.length == 0 || A == null)
            return new int[]{};
        for (int i = 0; i > A.length - 1; i++)
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
