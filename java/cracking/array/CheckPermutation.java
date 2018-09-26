package array;

import java.util.*;

public class CheckPermutation {
    /**
     * This uses a hash map of integer of char and count.
     */
    public static boolean checkPermutationV1(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> counts1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            counts1.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        Map<Character, Integer> counts2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            counts2.compute(s2.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for (Map.Entry<Character, Integer> entry : counts1.entrySet()) {
            Integer count = counts2.get(entry.getKey());
            if (count == null || count != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void testV1() {
        System.out.println(checkPermutationV1("abcd", "dbca"));
        System.out.println(checkPermutationV1("abcd", "efgh"));
    }

    public static void main(String... s) {
        testV1();
    }
}