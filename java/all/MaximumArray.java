class Solution {
    public int[] max(int [] nums, int start, int end) {
        if(end < start){
            return new int[] {0};
        }
        int mid = (start + end) / 2;
        int [] left = max(nums, start, mid - 1);
        int [] right = max(nums, mid + 1, end);
        
        int i = start;
        int j = end;
        int value = nums[mid];
        
        if(start == end) {
            System.out.println(Arrays.toString(new int[] {value, i, j}));
            return new int[] {value, i, j};
        }
        
        if(left[0] > 0 && left[2] == mid - 1) {
            i = left[1];
            value += left[0]; 
        }
        
        if(right[0] > 0 && right[1] == mid + 1) {
            j = right[2];
            value += right[0];    
        }
        
        int [] res = new int[] {value, i, j};
        if(left[0] > right[0]) {
            if(left[0] > value) {
                res = left;
            }
        } else {
            if(right[0] > value) {
                res = right;  
            } 
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
    
    public int maxSubArray(int[] nums) {
        int [] res = max(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(res));
        return res[0];    
    }
}