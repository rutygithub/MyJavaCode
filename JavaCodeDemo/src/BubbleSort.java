import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSort {
    public static void main(String[] args) {
        //offer书 P.170
        int[] array = {32, 12, 7, 78, 23, 45};
        System.out.println("original array " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("array after bubble sort " + Arrays.toString(array));
        //通过arrays.toString来输出string 很漂亮

        List list =  IntStream.of(array)     // IntStream
                .boxed()        // Stream<Integer> box int to wrappered integer
                .collect(Collectors.toList());
        System.out.print("using for each to print the arraylist { ");
        list.forEach(n -> System.out.print(n + " "));
        System.out.println("}");
    }

    public static void bubbleSort(int[] A) {
        for (int i = 0; i < A.length - 1; i++)
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
