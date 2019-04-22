package dp;

import java.util.*;

/**
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/
public class TripleStep {

  /**
   * Brute force solution O(3 ^ n)
   */
  public int countWaysV1(int n) {
    if(n < 0) {
      return 0;
    }
    if(n == 0) {
      return 1;
    }
    int one = countWaysV1(n - 1);
    int two = countWaysV1(n - 2);
    int three = countWaysV1(n - 3);

    return one + two + three;
  }

  /**
    Top down approach with memoization.
    Running time is almost linear
  */
  public int countWaysV2(int n, int [] memo) {
    if(n < 0) {
      return 0;
    }
    if(n == 0) {
      return 1;
    }
    if(memo[n] > 0) {
      return memo[n];
    }
    int one = countWaysV2(n - 1, memo);
    int two = countWaysV2(n - 2, memo);
    int three = countWaysV2(n - 3, memo);

    memo[n] = one + two + three;
    return memo[n];
  }

  /**
    Bottom up DP
  */
  public int countWaysV3(int n) {
    int [] calc = new int[n + 1];
    calc[0] = 1;
    int one;
    int two;
    int three;
    for(int i = 1; i <= n; i++) {
      one = (i - 1 >= 0) ? calc[i - 1] : 0;
      three = (i - 2 >= 0) ? calc[i - 2] : 0;
      two = (i - 3 >= 0) ? calc[i - 3] : 0;
      calc[i] = one + two + three;
    }
    return calc[n];
  }

  /**
    Optimized version.
  */
  public int countWaysV4(int n) {
    int [] calc = new int[3];
    calc[0] = 1;
    for(int i = 1; i <= n; i++) {
      int total = calc[(i - 1) % 3] + calc[(i) % 3] + calc[(i + 1) % 3];
      if(i <= 2) {
        calc[i] = total;
      } else {
        // shift;
        calc[0] = calc[1];
        calc[1] = calc[2];
        calc[2] = total;
      }
    }
    if(n <= 2) {
      return calc[n];
    }
    return calc[2];
  }

  public static void main(String... s) {
    TripleStep step = new TripleStep();
    System.out.println(step.countWaysV1(1));
    System.out.println(step.countWaysV1(2));
    System.out.println(step.countWaysV1(3));
    System.out.println(step.countWaysV1(4));
    System.out.println(step.countWaysV1(5));
    //System.out.println(step.countWaysV1(35));

    int size = 30;
    System.out.println(step.countWaysV2(size, new int[size + 1]));
    System.out.println(step.countWaysV3(size));
    System.out.println(step.countWaysV4(size));
    System.out.println(step.countWaysV4(1));
    System.out.println(step.countWaysV4(2));
    System.out.println(step.countWaysV4(3));
    System.out.println(step.countWaysV4(4));
  }
}
