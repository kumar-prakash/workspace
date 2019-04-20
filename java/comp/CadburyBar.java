package comp;

import java.util.*;

public class CadburyBar {

    private static int findCount(int i, int j) {
        if(i == j) {
            return 1;
        }
        if(i > j) {
            return 1 + findCount(i - j, j);
        } else {
            return 1 + findCount(i, j - i);
        }
    }

    public static int findNumberOfStudents(int n, int m, int p, int q) {
        int count = 0;
        for(int i = n; i <= m; i++) {
            for(int j = p; j <= q; j++) {
                System.out.println(i + "x" + j + "=" + findCount(i, j));
                count += findCount(i, j);
            }
        }
        return count;
    }

    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(findNumberOfStudents(n, m, p, q));
    }
}