import java.util.*;

public class DisjointSetTest {

  public static void main(String... s) {
      DisjointSet set = new DisjointSet(5);
      System.out.println(set.joint(1, 2));
      System.out.println(set.joint(3, 4));
      System.out.println(set.joint(2, 4));
      System.out.println(set.joint(2, 3));
      System.out.println(set.joint(2, 5));
      System.out.println(set.joint(5, 4));
      System.out.println(set.joint(1, 5));
  }
}
