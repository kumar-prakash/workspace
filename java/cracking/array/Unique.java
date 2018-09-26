package array;

public class Unique {
    /**
     * This is the brute force algorithm
     */
    public static boolean hasUniqueCharsV1(String str) {
        if(str == null || str.isEmpty()) {
            return true;
        }
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This will assume that the total chars are from a-z,
     * It uses an array of boolean as a hash area.
     */
    public static boolean hasUniqueCharsV2(String str) {
        if(str == null || str.isEmpty()) {
            return true;
        }

        boolean [] cache = new boolean[26];
        for(int i = 0; i < str.length(); i++) {
            int code = (int)str.charAt(i) - 97;
            if(cache[code]) {
                return false;
            } else {
                cache[code] = true;
            }
        }
        return true;
    }

    private static void printArr(char [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    /**
     * This does the sorting in O(n*n) time.
     */
    private static void sortArr(char [] arr) {
        printArr(arr);
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    // swap j and j + 1
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArr(arr);
    }

    /**
     * This version does the following
     * 1. Converts the str to char array
     * 2. Sorts the array in O(nlogn) time.
     * 3. Checks for duplicacy in O(n) time.
     */
    public static boolean hasUniqueCharsV3(String str) {
        if(str == null || str.isEmpty()) {
            return true;
        }
        char [] arr = str.toCharArray();
        sortArr(arr);
        char lastChar = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == lastChar) {
                return false;
            }
            lastChar = arr[i];
        }
        return true;
    }

    public static void testV2(){
        System.out.println(hasUniqueCharsV2("abcdefghij"));
        System.out.println(hasUniqueCharsV2("abcdeeee"));
        System.out.println(hasUniqueCharsV2(null));
    }

    public static void testV1() {
        System.out.println(hasUniqueCharsV1("abcdefghij"));
        System.out.println(hasUniqueCharsV1("abcdeeee"));
        System.out.println(hasUniqueCharsV1(null));
    }

    public static void testV3() {
        System.out.println(hasUniqueCharsV3("abcdef"));
        System.out.println(hasUniqueCharsV3("bcdeaaf"));
        System.out.println(hasUniqueCharsV3("abcdad"));
    }

    public static void main(String... s) {
        testV3();
    }
}