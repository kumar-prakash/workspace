import java.util.*;

public class MatrixChain {
    public static int[] findMinCal(int [] arr, int start) {
        if(start == arr.length - 1) {
            return new int[] {arr[start - 1], arr[start], 0};
        }

        int min = Integer.MAX_VALUE;
        int opSofar = 0;
        int r = arr[start - 1];
        int c = arr[start];
        for(int i = start; i < arr.length - 1; i++) {
            c = arr[i];
            if(i > start) {
                opSofar += (arr[i - 2] * arr[i - 1] * arr[i]);
            }
            int [] res = findMinCal(arr, i + 1);
            int temp = opSofar + res[2] + (r * c * res[1]);
            if(temp < min) {
                min = temp;
            }
            c = res[1];
        }
        return new int[] {r, c, min};
    }

    public static int calculateNoOfOperationsV1(int [] arr, int start, int end) {
        if(start == end) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = start; i < end; i++) {
            int p = arr[start - 1];
            int q = arr[i];
            int r = arr[end];

            int leftOperations = calculateNoOfOperationsV1(arr, start, i);
            int rightOperations = calculateNoOfOperationsV1(arr, i + 1, end);
            int currentOperations = p * q * r;
            int sum = leftOperations + rightOperations + currentOperations;
            if(sum < min) {
                min = sum;
            }
        }
        return min;
    }

    public static int calculateNoOfOperationsV2(int [] arr, int start, int end) {
        if(start == end) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = start; i < end; i++) {
            int sum = calculateNoOfOperationsV2(arr, start, i) + calculateNoOfOperationsV2(arr, i + 1, end) + (arr[start - 1] * arr[i] * arr[end]);
            if(sum < min) {
                min = sum;
            }
        }
        return min;
    }

    public static int calculateNoOfOperationsV3(int [] arr, int start, int end, StringBuilder parenthesis) {
        if(start == end) {
            parenthesis.append(start);
            return 0;
        }

        int min = Integer.MAX_VALUE;
        String s1 = "";
        String s2 = "";
        for(int i = start; i < end; i++) {
            StringBuilder b1 = new StringBuilder("");
            StringBuilder b2 = new StringBuilder("");
            int sum = calculateNoOfOperationsV3(arr, start, i, b1) + calculateNoOfOperationsV3(arr, i + 1, end, b2) + (arr[start - 1] * arr[i] * arr[end]);
            if(sum < min) {
                min = sum;
                s1 = b1.toString();
                s2 = b2.toString();
            }
        }
        parenthesis.append("(").append(s1).append(s2).append(")");
        return min;
    }

    public static int calculateNoOfOperationsV4(int [] arr, int length) {
        int [][] data = new int[length][length];
        for(int i = 2; i < length; i++) {
            for(int j = 1; j < length; j++) {
                for(int k = j; k < j + i; k++) {
                    int min = Integer.MAX_VALUE;
                    // divide into two half
                    for(int l = k; l < j + i - 1; l++) {
                        int temp = data[k][l] + data[l + 1][j + i - 1] + (arr[k - 1] * arr[l] * arr[j + i - 1]);
                        if(temp < min) {
                            min = temp;
                        }
                    }
                    
                }
            }
        }
        return 0;
    }

    public static void main(String... s) {
        int [][] input = {
            {40, 20, 30, 10, 30},
            {10, 30, 5, 60},
            {10, 20, 30, 40, 30},
            {10, 20, 30}//,
            //{40, 20, 30, 10, 30, 40, 20, 30, 10, 30, 40, 20, 30, 10, 30, 40, 20, 30, 10, 30, 30, 40, 20, 30, 10, 30, 40, 20, 30, 10, 30}
        };

        /*
        for(int i = 0; i < input.length; i++) {
            System.out.println(calculateNoOfOperationsV2(input[i], 1, input[i].length - 1));
        }
        */

        /*
        for(int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder("");
            calculateNoOfOperationsV3(input[i], 1, input[i].length - 1, sb);
            System.out.println(sb);
        }
        */

        calculateNoOfOperationsV4(input[0], input[0].length);
    }
}