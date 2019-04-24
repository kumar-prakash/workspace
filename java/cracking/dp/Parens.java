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
    generate(arr, size, n - 1, result);
    int offset = (size - n) + 1;
    int length = arr.length - 1;
    for(int i = offset; i < size; i++) {
      for(int j = offset; j < size; j++) {
        char [] nArr = Arrays.copyOf(arr, arr.length);
        swap(nArr, i, length - j);
        result.add(new String(nArr));
      }
    }

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
    List<String> result = p.generateParens(4);
    Set<String> col = new HashSet<>(result);
    System.out.println(col);
  }
}
