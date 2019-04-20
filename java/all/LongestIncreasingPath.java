public class LongestIncreasingPath {
    public int findLength(int [][] mat, int i, int j, boolean [][] visited, int [][] memo) {
        if(visited[i][j]) {
            return 0;
        }
        if(memo[i][j] > 0) {
          return memo[i][j];
        }
        int [] x = new int[] {-1, 0, 0, 1};
        int [] y = new int[] {0, -1, 1, 0};
        int iLen = mat.length;
        int jLen = mat[0].length;

        int maxLength = 0;
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            int ni = i + x[k];
            int nj = j + y[k];

            if(0 <= ni && ni < iLen && 0 <= nj && nj < jLen && mat[ni][nj] > mat[i][j]) {
                int tempLength = findLength(mat, ni, nj, visited, memo);
                if(tempLength > maxLength) {
                    maxLength = tempLength;
                }
            }
        }
        visited[i][j] = false;
        maxLength += 1;
        memo[i][j] = maxLength;
        return maxLength;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int iLen = matrix.length;
        int jLen = matrix[0].length;

        boolean [][] visited = new boolean[iLen][jLen];
        int max = 0;
        for(int i = 0; i < iLen; i++) {
            for(int j = 0; j < jLen; j++) {
                int temp = findLength(matrix, i, j, visited, new int[iLen][jLen]);
                if(temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public static void main(String... s) {
      int [][] mat = new int[][] {
        {0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}
      };
      // int [][] mat = new int[][] {
      //   {9,9,4},{6,6,8},{2,1,1}
      // };
      int longestPath = new LongestIncreasingPath().longestIncreasingPath(mat);
      System.out.println(longestPath);
    }
}
