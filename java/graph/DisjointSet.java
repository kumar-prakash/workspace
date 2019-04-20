import java.util.*;

public class DisjointSet {
  private int capacity;
  private int [] data;

  public DisjointSet(int capacity) {
    this.capacity = capacity;
    data = new int[capacity];
    while(--capacity >= 0) {
      data[capacity] = -1;
    }
  }

  public int findSet(int item) {
    if(item > capacity) {
      throw new IllegalArgumentException("Invalid item: " + item);
    }
    item--;
    int index = item;
    int pathLength = 0;
    while(data[index] >= 0) {
      index = data[index];
      pathLength++;
    }
    if(pathLength > 0) {
      data[item] = index;
    }
    return index;
  }

  public boolean union(int s1, int s2) {
    if(s1 == s2) {
      return false;
    }
    int c1 = Math.abs(data[s1]);
    int c2 = Math.abs(data[s2]);
    if(c1 > c2) {
      data[s2] = s1;
      data[s1] = data[s1] + (-1 * c2);
    } else {
      data[s1] = s2;
      data[s2] = data[s2] + (-1 * c1);
    }
    return true;
  }

  public boolean joint(int item1, int item2) {
    return union(findSet(item1), findSet(item2));
  }
}
