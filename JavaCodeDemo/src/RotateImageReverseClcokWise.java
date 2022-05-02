import java.util.Arrays;

public class RotateImageReverseClcokWise {
    public static void main(String[] args) {
        int[][] m1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(m1);
        for (int i = 0; i < m1.length; i++) {
            System.out.println(Arrays.toString(m1[i]));
        }
        System.out.println();
        int[][] m2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(m2);
        for (int i = 0; i < m2.length; i++) {
            System.out.println(Arrays.toString(m2[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        // https://discuss.leetcode.com/topic/9744/ac-java-in-place-solution-with-explanation-easy-to-understand
        // The idea was firstly transpose the matrix and then flip it symmetrically
        //anticlosewise 就是其他跟clockwise一样，就是flip through the i index
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length / 2; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }
}
