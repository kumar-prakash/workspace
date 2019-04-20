public class TrapRainwater {
    void fill(int [] height, int start, int end, int k) {
        for(int i = start; i <= end; i++) {
            height[i] += k;
        }
    }

    public int trap(int[] height) {
        if(height == null || height.length < 3) {
            return 0;
        }

        int len = height.length;
        int total = 0;
        int start = 1;
        int end = 1;
        int h;
        int level;
        while(start < len) {
            while(start - 1 >= 0 && height[start - 1] == height[start]) {
                start--;
            }

            while(end + 1 < len && height[end + 1] == height[end]) {
                end++;
            }

            h = Math.max(height[start], height[end]);
            if(start - 1 >= 0 && end + 1 < len && height[start - 1] > h && height[end + 1] > h) {
                if(height[start - 1] > height[end + 1]) {
                    end++;
                    level = height[end] - h;
                    total += level * (end - start);
                    fill(height, start, end - 1, level);
                } else if(height[start - 1] < height[end + 1]) {
                    start--;
                    level = height[start] - h;
                    total += level * (end - start);
                    fill(height, start + 1, end, level);
                } else {
                    end++;
                    start--;
                    level = height[end] - h;
                    total += level * (end - start - 1);
                    fill(height, start + 1, end - 1, level);
                }
            } else {
                start = end + 1;
                end = start;
            }
        }

        return total;
    }

    public static void main(String... s) {
      // {0,1,0,2,1,0,1,3,2,1,2,1}
      // {4,3,2,1,1,1,3,2}
      int [] data = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
      System.out.println(new TrapRainwater().trap(data));
    }
}
