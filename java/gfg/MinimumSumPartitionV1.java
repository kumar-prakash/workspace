import java.util.*;

public class MinimumSumPartitionV1 {
    private int diff;

    public MinimumSumPartitionV1() {
        this.diff = Integer.MAX_VALUE;
    }

    private void checkDiff(int [] arr, boolean [] partition, int size) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < size; i++) {
            if(partition[i]) {
                sum1 += arr[i];
            } else {
                sum2 += arr[i];
            }
        }

        int diff = Math.abs(sum1 - sum2);
        if(diff < this.diff) {
            this.diff = diff;
        }
    }

    private void createPartition(int [] arr, int start, int size, boolean [] partition) {
        if(start > 0) {
            checkDiff(arr, partition, size);
        }

        for(int i = start; i < size; i++) {
            boolean [] temp = Arrays.copyOf(partition, size);
            temp[i] = true;
            createPartition(arr, i + 1, size, temp);
        }
    }

    public static void main(String... s) {
        MinimumSumPartitionV1 obj = new MinimumSumPartitionV1();
        obj.createPartition(new int [] {36, 7, 46, 40}, 0, 4, new boolean[4]);
        System.out.println(obj.diff);

        obj = new MinimumSumPartitionV1();
        obj.createPartition(new int [] {1, 6, 5, 11}, 0, 4, new boolean[4]);
        System.out.println(obj.diff);

        obj = new MinimumSumPartitionV1();
        obj.createPartition(new int [] {4, 3, 1, 10, 18, 12, 13, 2}, 0, 8, new boolean[8]);
        System.out.println(obj.diff);

        obj = new MinimumSumPartitionV1();
        obj.createPartition(new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30}, 0, 30, new boolean[30]);
        System.out.println(obj.diff);
    }
}