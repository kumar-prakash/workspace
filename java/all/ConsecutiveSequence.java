import java.util.*;

public class ConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!visited.contains(nums[i])) {
                int start = nums[i];
                int end = nums[i];

                Integer l = count.get(nums[i] - 1);
                Integer n = count.get(nums[i] + 1);
                if(l != null) {
                    start = l;
                    count.remove(l);
                    count.remove(nums[i] - 1);
                }
                if(n != null) {
                    end = n;
                    count.remove(n);
                    count.remove(nums[i] + 1);
                }
                count.put(start, end);
                count.put(end, start);

                int diff = (int) Math.abs(start - end) + 1;
                if(diff > maxLength) {
                    maxLength = diff;
                }
            }
            visited.add(nums[i]);
            System.out.println(count);
        }
        return maxLength;
    }

    public static void main(String... s) {
      int [] data = new int[] {7,-2,9,9,1,9,8,-4,6,-6,-6,4,1,3,6,3,5,-2,3,4,-6,1,5,-9,6,1,2,-2,1};
      System.out.println(new ConsecutiveSequence().longestConsecutive(data));
    }
}
