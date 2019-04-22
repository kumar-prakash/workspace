package dp;

import java.util.*;

public class RobotInGrid {
  public void makeGrid(int [][] grid, int [][] offLimit) {
      for(int [] cell: offLimit) {
        grid[cell[0]][cell[1]] = -1;
      }
  }

  public boolean makePath(int [][] grid, int r, int c, int i, int j) {
      if(i == r - 1 && j == c - 1) {
        return true;
      }
      if(i >= r || j >= c)  {
        return false;
      }

      if(grid[i][j] == -1) {
        return false;
      }
      boolean result = makePath(grid, r, c, i, j + 1) ||  makePath(grid, r, c, i + 1, j);
      if(result) {
        grid[i][j] = 101;
      } else {
        grid[i][j] = -1;
      }
      return result;
  }

  public void findPath(int [][] grid, int r, int c, int [][] offLimit) {
    makeGrid(grid, offLimit);
    makePath(grid, r, c, 0, 0);
  }

  public static void main(String... s) {
    int r = 40;
    int c = 40;
    int [][] mat = new int[r][c];
    int [][] offLimit = new int[][] {
      {38, 1},
      {38, 2},
      {38, 3},
      {38, 4},
      {38, 5},
      {38, 6},
      {38, 7},
      {38, 8},
      {38, 9},
      {38, 10},
      {38, 11},
      {38, 12},
      {38, 13},
      {38, 14},
      {38, 15},
      {38, 16},
      {38, 17},
      {38, 18},
      {38, 19},
      {38, 20},
      {38, 21},
      {38, 22},
      {38, 23},
      {38, 24},
      {38, 25},
      {38, 26},
      {38, 27},
      {38, 28},
      {38, 29},
      {38, 31},
      {38, 30},
      {38, 32},
      {38, 33},
      {38, 34},
      {38, 35},
      {38, 36},
      {38, 37},
      {38, 38},
      {38, 39}
    };

    RobotInGrid grid = new RobotInGrid();
    grid.findPath(mat, r, c, offLimit);
    print(mat);
  }

  public static void print(int [][] grid) {
    for(int [] row: grid) {
      System.out.println(Arrays.toString(row));
    }
  }
}
