import java.util.*;

public class Factorial {
    private static Map<Integer, Long> cache = new HashMap<>();

    static long fact(int n) {
        if(n == 0) {
            return 1;
        }
        long fact;
        Long cachedValue = cache.get(n - 1);
        if(cachedValue != null) {
            fact = n * cachedValue;
        } else {
            fact = n * fact(n - 1);
        }
        cache.put(n, fact);
        return fact;
    }

    public static void main(String... s) {
        long start = System.currentTimeMillis();
        for(int i = 1; i < 1000000; i++) {
            fact(i);
            //System.out.println("Factorial of: " + i + " = " + fact + ", time = " + (end - start));
        }
        long end = System.currentTimeMillis();
        System.out.println("Calculation time is: " + (end - start));
    }
}