import java.util.*;

public class Subsequence {

    public static void findSubsequenceV1(String [] arr, int size) {
        Map<String, List<String>> cache = new HashMap<>();
        cache.put(arr[size - 1], Arrays.asList(arr[size - 1]));
        for(int i = size - 2; i >= 0; i--) {
            List<String> nList = new ArrayList<>();
            nList.add(arr[i]);
            for(int j = i + 1; j < size; j++) {
                List<String> list = cache.get(arr[j]);
                for(String temp: list) {
                    nList.add(arr[i] + temp);
                }
            }
            cache.put(arr[i], nList);
        }

        //System.out.println(cache);
    }

    public static void findSubsequenceV2(String [] arr, int start, String str, int size) {
        if(!str.isEmpty()) {
            //System.out.println(str);
        }
        for(int i = start; i < size; i++) {
            findSubsequenceV2(arr, i + 1, str + arr[i], size);
        }
    }

    public static void main(String... s) {
        String [] arr1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "H", "I", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String [] arr2 = {"A", "B", "C", "D", "E"};

        //findSubsequenceV1(arr2, arr2.length);
        findSubsequenceV1(arr1, arr1.length);

        
        //findSubsequenceV2(arr1, 0, "", arr1.length);
    }
}