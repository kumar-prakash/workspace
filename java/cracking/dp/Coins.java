package dp;

public class Coins {
  public int noOfWays(int n) {
    if(n == 0) {
      return 1;
    } else if(n < 0) {
      return 0;
    }
    int total = 0;
    int a = noOfWays(n - 1);
    int b = noOfWays(n - 5);
    int c = noOfWays(n - 10);
    int d = noOfWays(n - 25);
    total = a + b + c + d;
    return total;
  }

  public static void main(String... s) {
    Coins c = new Coins();
    System.out.println(c.noOfWays(1));
    System.out.println(c.noOfWays(2));
    System.out.println(c.noOfWays(3));
    System.out.println(c.noOfWays(5));
    System.out.println(c.noOfWays(6));
    System.out.println(c.noOfWays(6));
    System.out.println(c.noOfWays(10));
    // System.out.println(c.noOfWays(11));
    // System.out.println(c.noOfWays(15));
    // System.out.println(c.noOfWays(25));
    // System.out.println(c.noOfWays(30));
  }
}
