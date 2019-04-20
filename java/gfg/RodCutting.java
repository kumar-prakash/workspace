import java.util.*;
public class RodCutting {

    public static int findMaxRev(int [] price, int n) {
        if(n == 0) {
            return 0;
        }

        int rev = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            rev = Math.max(rev, price[i] + findMaxRev(price, n - i - 1));
        }
        return rev;
    }

    public static int findMaxRev1(int [] price, int n, int [] computed) {
        if(n == 0) {
            return 0;
        }
        if(computed[n - 1] != 0) {
            return computed[n - 1];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, price[i] + findMaxRev1(price, n - i - 1, computed));
        }
        computed[n - 1] = max;
        return max;
    }

    public static int findMaxRev1(int [] price, int n, int [] computed, int [] path) {
        if(n == 0) {
            return 0;
        }
        if(computed[n - 1] != 0) {
            return computed[n - 1];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int temp = price[i] + findMaxRev1(price, n - i - 1, computed, path);
            if(temp > max) {
                max = temp;
                path[n - 1] = i + 1;
            }
        }
        computed[n - 1] = max;
        return max;
    }

    public static int findMaxRev2(int [] price, int length) {
        int [] computed = new int [length + 1];
        computed[0] = 0;
        int [] path = new int[length + 1];
        for(int i = 1; i <= length; i++) {
            int rev = 0;
            for(int j = 1; j <= i; j++) {
                int temp = price[j - 1] + computed[i - j];
                if(temp > rev) {
                    rev = temp;
                    path[i] = j;
                }
            }
            computed[i] = rev;
        }

        System.out.println(Arrays.toString(path));
        return computed[length];
    }

    public static int findMaxRev2(int [] price, int length, int [] path) {
        int [] computed = new int [length + 1];
        computed[0] = 0;
        for(int i = 1; i <= length; i++) {
            int rev = 0;
            for(int j = 1; j <= i; j++) {
                int temp = price[j - 1] + computed[i - j];
                if(temp > rev) {
                    rev = temp;
                    path[i] = j;
                }
            }
            computed[i] = rev;
        }
        return computed[length];
    }

    public static int findMaxRev2(int [] price, int length, int cost) {
        int [] computed = new int [length + 1];
        computed[0] = 0;
        int [] path = new int[length + 1];
        for(int i = 1; i <= length; i++) {
            int rev = 0;
            for(int j = 1; j <= i; j++) {
                int temp = price[j - 1] + computed[i - j];
                if(i - j > 0) {
                    temp -= cost;
                }
                if(temp > rev) {
                    rev = temp;
                    path[i] = j;
                }
            }
            computed[i] = rev;
        }

        System.out.println(Arrays.toString(path));
        return computed[length];
    }

    static int[] getArr(int n) {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
        return arr;
    }
    public static void main(String... s) {
        int [] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 25, 35, 40, 41, 45, 55, 60, 63, 70, 1, 5, 8, 9, 10, 8, 9, 10, 1, 5, 8, 9, 10, 8, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 35, 40, 41, 45, 55, 60, 63, 70, 1, 5, 8, 9, 10, 8, 9, 10, 1, 5, 8, 9, 10, 8};
        //int [] price = {1, 5, 8, 9};
        //System.out.println(findMaxRev(price, price.length));
        //System.out.println(findMaxRev1(price, price.length, new int[price.length]));
        int [] path1 = new int[11];
        System.out.println(findMaxRev2(price, 10, path1 ));
        System.out.println(Arrays.toString(path1));
        //System.out.println(findMaxRev2(price, 10, 10));

        int [] path2 = new int[10];
        System.out.println(findMaxRev1(price, 10, new int[10], path2));
        System.out.println(Arrays.toString(path2));
    }
}