package dp;

import java.util.*;

public class PowerSet {
  public void power(int [] arr, List<Integer> list, int start, List<List<Integer>> result) {
    if(start >= arr.length) {
      //result.add(list);
      return;
    }
    for(int i = start; i < arr.length; i++) {
      List<Integer> temp = new ArrayList<>(list);
      temp.add(arr[i]);
      result.add(temp);
      power(arr, temp, i + 1, result);
    }
  }

  public void powerOrder(int [] arr, List<Integer> list, int start, List<List<Integer>> result) {
    if(start >= arr.length) {
      return;
    }
    for(int i = start; i < arr.length; i++) {
      List<Integer> temp = new ArrayList<>(list);
      temp.add(arr[i]);
      result.add(temp);
    }
    for(int i = start; i < arr.length; i++) {
        power(arr, result.get(i), i + 1, result);
    }
  }

  public List<List<Integer>> powerSet(int [] arr) {
    List<List<Integer>> result = new ArrayList<>();
    //power(arr, new ArrayList<Integer>(), 0, result);
    powerOrder(arr, new ArrayList<Integer>(), 0, result);
    return result;
  }

  public static void main(String... s) {
    PowerSet set = new PowerSet();
    print(set.powerSet(new int[] {1, 2, 3, 4}));
  }

  public static void print(List<List<Integer>> list) {
    for(List<Integer> l: list) {
      System.out.println(l);
    }
  }
}
