package dp;

import java.util.*;

public class Parens {

  public void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void generate(char [] arr, int size, int n, List<String> result) {
    if(n == 1) {
      result.add(new String(arr));
      return;
    }

    int offset = (size - n) + 1;
    int length = arr.length - 1;
    for(int i = 0 + offset; i < n; i++) {
      for(int j = 0 + offset; j < n; j++) {
        char [] nArr = Arrays.copyOf(arr, arr.length);
        swap(nArr, i, length - j);
        result.add(new String(nArr));
      }
    }
    generate(arr, size, n - 1, result);
  }

  public List<String> generateParens(int n) {
    char [] arr = new char[n * 2];
    Arrays.fill(arr, 0, n, '(');
    Arrays.fill(arr, n, arr.length, ')');
    List<String> list = new ArrayList<>();
    generate(arr, n, n, list);
    return list;
  }

  public static void main(String... s) {
    Parens p = new Parens();
    //System.out.println(p.generateParens(3));
    //System.out.println(p.generateParens(4));
    System.out.println(p.generateParens(3));
  }
}
