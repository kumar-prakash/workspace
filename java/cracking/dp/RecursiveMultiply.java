package dp;

import java.util.*;

public class RecursiveMultiply {
    public int multiply(int n, int m, Map<Integer, Integer> memo) {
      if(m == 1) {
        return n;
      }
      if(memo.containsKey(m)) {
        return memo.get(m);
      }
      int mid = m / 2;
      int result = multiply(n, mid, memo) + multiply(n, m - mid, memo);
      memo.put(m, result);
      return result;
    }

    public static void main(String... s) {
      RecursiveMultiply mul = new RecursiveMultiply();
      System.out.println(mul.multiply(5, 800, new HashMap<Integer, Integer>()));
    }
}
