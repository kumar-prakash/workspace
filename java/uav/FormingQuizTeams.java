import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FormingQuizTeams {
  private static final DecimalFormat format = new DecimalFormat("######################.##");

  public static double distance(Integer [] p1, Integer [] p2) {
      return Math.sqrt(Math.pow(p2[0] - p1[0], 2.0d) + Math.pow(p2[1] - p1[1], 2.0d));
  }

  public static double findMinDistance(Map<String, Integer []> data, Set<String> visited) {
    if(visited.size() == data.size()) {
      return 0.0d;
    }
    Map.Entry<String, Integer[]> s1 = null;
    Map.Entry<String, Integer[]> s2;

    double min = Double.MAX_VALUE;
    for(Map.Entry<String, Integer[]> e1: data.entrySet()) {
        if(!visited.contains(e1.getKey())) {
          s1 = e1;
          visited.add(s1.getKey());

          for(Map.Entry<String, Integer[]> e2: data.entrySet()) {
              if(!visited.contains(e2.getKey())) {
                s2 = e2;
                visited.add(s2.getKey());
                double dis = distance(s1.getValue(), s2.getValue()) + findMinDistance(data, visited);
                if(dis < min) {
                  min = dis;
                }
                visited.remove(s2.getKey());
              }
          }
          visited.remove(s1.getKey());
        }
    }
    return min;
  }

  static void test() {
    Map<String, Integer[]> data = new HashMap<>();
    data.put("a", new Integer [] {1, 1});
    data.put("b", new Integer [] {8, 6});
    data.put("c", new Integer [] {1, 3});
    data.put("d", new Integer [] {6, 8});
    System.out.println(findMinDistance(data, new HashSet<>()));
  }

  public static void main(String... s) throws IOException {
    format.setRoundingMode(RoundingMode.CEILING);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int pair = Integer.parseInt(br.readLine());
      int cases = 1;
      while(pair != 0) {
        Map<String, Integer[]> data = new HashMap<>();
        for(int i = 0; i < pair * 2; i++) {
            String [] parts = br.readLine().split(" ");
            data.put(parts[0],
              new Integer[] {Integer.parseInt(parts[1]), Integer.parseInt(parts[2])});
        }
        System.out.println("Case " + cases + ": " + format.format(findMinDistance(data, new HashSet<>())));
        pair = Integer.parseInt(br.readLine());
        cases++;
      }
      //test();
  }
  /**
5
sohel 10 10
mahmud 20 10
sanny 5 5
prince 1 1
per 120 3
mf 6 6
kugel 50 60
joey 3 24
limon 6 9
manzoor 0 0
1
derek 9 9
jimmy 10 10
8
sohel 10 10
mahmud 20 10
sanny 5 5
prince 1 1
per 120 3
mf 6 6
kugel 50 60
joey 3 24
limon 6 9
manzoor 0 0
a 1 1
b 2 2
c 3 3
d 4 4
e 5 5
f 6 6
0

  */
}
