package array;

import java.util.*;
public class RotateMatrix {
    public static void rotate(int [][] arr, int length) {
        int n = length - 1;
        for(int i = 0; i < length / 2; i++) {
            for(int j = i; j <= n - i - 1; j++) {
                int temp1 = arr[j][n - i];
                arr[j][n - i] = arr[i][j];

                int temp2 = arr[n - i][n - j];
                arr[n - i][n - j] = temp1;

                temp1 = arr[n - j][i];
                arr[n - j][i] = temp2;

                arr[i][j] = temp1;
            }
        }
    }

    public static void printMatrix(int [][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String... s) {
        int [][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int [][] mat2 = {
            {1, 2, 3, 4},
        };

        printMatrix(mat1);
        System.out.println("");
        rotate(mat1, mat1.length);
        printMatrix(mat1);
    }
}