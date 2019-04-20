package array;
import java.util.*;

public class ZeroMatrix {
    static void clearRows(int [][] mat, int size, Set<Integer> rows) {
        for(Integer row: rows) {
            for(int i = 0; i < size; i++) {
                mat[row][i] = 0;
            }
        }
    }

    static void clearColumns(int [][] mat, int size, Set<Integer> cols) {
        for(Integer col: cols) {
            for(int i = 0; i < size; i++) {
                mat[i][col] = 0;
            }
        }
    }

    static void zeroMatrix(int [][] mat, int n, int m) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        clearRows(mat, m, rows);
        clearColumns(mat, n, cols);
    }

    public static void printMatrix(int [][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        System.out.println("");
    }

    public static void main(String... s) {
        int [][] mat = {
            {1, 1, 1, 1},
            {0, 1, 1, 0},
            {1, 1, 1, 0},
            {1, 1, 1, 1}
        };

        printMatrix(mat);
        zeroMatrix(mat, 4, 4);
        printMatrix(mat);
    }
}