import java.util.*;

public class MinimumSumPartitionV2 {
   
    private String getHash(int [] arr, boolean [] partition) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < partition.length; i++) {
            if(partition[i]) {
                builder.append(arr[i]).append(",");
            }
        }

        return builder.toString();
    }

    private Integer getTotal(int [] arr, boolean [] partition, Map<String, Integer> cache) {
        return cache.get(getHash(arr, partition));
    }

    
    private static Map<String, Integer> createCache(int [] arr) {
        Map<String, Integer> cache = new HashMap<>();
        for(int n: arr) {
            cache.put(n + ",", n);
        }
        return cache;
    }

    public static void main(String... s) {
        MinimumSumPartitionV2 obj = new MinimumSumPartitionV2();
        int [] arr;
        arr = new int [] {36, 7, 46, 40};
        obj.createPartition(arr, 0, arr.length, new boolean[arr.length], createCache(arr));
        System.out.println(obj.diff);

        obj = new MinimumSumPartitionV2();
        arr = new int [] {1, 6, 5, 11};
        obj.createPartition(arr, 0, arr.length, new boolean[arr.length], createCache(arr));
        System.out.println(obj.diff);

        obj = new MinimumSumPartitionV2();
        arr = new int [] {4, 3, 1, 10, 18, 12, 13, 2};
        obj.createPartition(arr, 0, arr.length, new boolean[arr.length], createCache(arr));
        System.out.println(obj.diff);

        obj = new MinimumSumPartitionV2();
        arr = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        obj.createPartition(arr, 0, arr.length, new boolean[arr.length], createCache(arr));
        System.out.println(obj.diff);
    }
}