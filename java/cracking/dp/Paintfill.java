package dp;

import java.util.*;

public class Paintfill {
  public void fill(int [][] pic, int r, int c, int x, int y, int oldColor, int newColor) {
    int [] xArr = new int[] {0, -1, 0, 1};
    int [] yArr = new int[] {-1, 0, 1, 0};

    pic[x][y] = newColor;
    for(int i = 0; i < 4; i++) {
      int nx = x + xArr[i];
      int ny = y + yArr[i];
      if(nx >= 0 && nx < r && ny >= 0 && ny < c && pic[nx][ny] == oldColor) {
          fill(pic, r, c, nx, ny, oldColor, newColor);
      }
    }
  }

  public static void main(String... s) {
    int [][] pic = new int[][] {
      {1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0, 0},
      {1, 0, 0, 1, 1, 0, 1, 1},
      {1, 2, 2, 2, 2, 0, 1, 0},
      {1, 1, 1, 2, 2, 0, 1, 0},
      {2, 1, 1, 2, 2, 2, 2, 0},
      {2, 1, 1, 1, 1, 2, 1, 1},
      {2, 1, 1, 1, 1, 2, 2, 1},
      };
    Paintfill p = new Paintfill();
    p.fill(pic, pic.length, pic[0].length, 4, 4, pic[4][4], 3);
    p.fill(pic, pic.length, pic[0].length, 5, 0, pic[5][0], 6);
    print(pic);
  }

  public static void print(int [][] arr) {
    for(int [] temp: arr) {
        System.out.println(Arrays.toString(temp));
    }
  }
}
