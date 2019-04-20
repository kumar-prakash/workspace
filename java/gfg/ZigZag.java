import java.util.*;

public class ZigZag {
    public int longestZigZag(int arr[]) {
    	int length = arr.length;
        if(length == 1) {
        	return 1;
        }
        int [] pArr = new int[length];
        int [] nArr = new int[length];
        pArr[0] = 1;
        nArr[0] = 1;

        for(int i = 1; i < length; i++) {
            pArr[i] = 1;
            nArr[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                	int total = pArr[j] + 1;
                    if(total > nArr[i]) {
                        nArr[i] = total;
                    }
                } else if(arr[i] < arr[j]) {
                    int total = nArr[j] + 1;
                	if(total > pArr[i]) {
                    	pArr[i] = total;
                    }
                }
            }
        }
        return Math.max(pArr[length - 1], nArr[length - 1]);
    }
}
