import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        //offer书 P.172
        int array[] = {32, 12, 7, 78, 23, 45};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
        //通过arrays.toString来输出string 很漂亮
    }

    public static int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int insertVal = A[i];
            int index = i - 1;
            while (index >= 0 && insertVal < A[index]) {
                A[index + 1] = A[index];
                index--;
            }
            A[index + 1] = insertVal;
        }
        return A;
    }

}
