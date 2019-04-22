package dp;

import java.util.*;

public class Permutation {

  public void swap(char [] arr, int i, int j) {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }

  /**
  Permutation with out duplicate
  uses backtracking instead of copying the source array;
  */
  public void permute(char [] arr, int index, List<String> result) {
    if(index == arr.length) {
      result.add(new String(arr));
      return;
    }

    for(int i = index; i < arr.length; i++) {
      swap(arr, i, index);
      permute(arr, index + 1, result);
      swap(arr, i, index); // backtracking step
    }
  }

  public void permuteWithDups(char [] arr, int index, List<String> result) {
    if(index == arr.length) {
      result.add(new String(arr));
      return;
    }

    for(int i = index; i < arr.length; i++) {
      if(arr[i] != arr[index]) {
        swap(arr, i, index);
        permute(arr, index + 1, result);
        swap(arr, i, index); // backtracking step
      } else if(i == index) {
        permute(arr, index + 1, result);
      }
    }
  }

  public static void main(String... s) {
    Permutation per = new Permutation();
    List<String> result = new ArrayList<String>();
    //per.permute("1234".toCharArray(), 0, result);
    per.permuteWithDups("1231".toCharArray(), 0, result);
    System.out.println(result);
  }
}
