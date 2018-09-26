package array;

import java.util.*;

public class PalindromePermutation {
    public static boolean isPalindromePermutation(String str) {
        if(str == null || str.isEmpty() || str.length() == 1) {
            return true;
        }
        HashMap<Character, Integer> cache = new HashMap<>();
        for (char c: str.toCharArray()) {
            if (c != ' ') {
                cache.compute(Character.toLowerCase(c), (k, v) -> v == null? 1: v + 1);
            }
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry: cache.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void test() {
        System.out.println(isPalindromePermutation("Tact Coa"));
        System.out.println(isPalindromePermutation("abcd"));
        System.out.println(isPalindromePermutation("tttbbbttt"));
    }

    public static void main(String... s) {
        test();
    }
}