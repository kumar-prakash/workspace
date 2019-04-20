
public class BadNeighbors {
    int findMax(int [] d) {
        int max = 0;
        for(int temp: d) {
        	if(temp > max) {
            	max = temp;
            }
        }
        return max;
    }
	public int maxDonations(int [] d) {
        if(d == null || d.length == 0) {
        	return 0;
        }
        int length = d.length;
        if(d.length <= 3) {
        	return findMax(d);
        }

        int max1 = 0;
        int [] calc = new int[length - 1];
        for(int i = 0; i < length - 1; i++) {
            calc[i] = d[i];
            int localMax = 0;
        	for(int j = 0; j <= i - 2; j++) {
            	if(calc[j] > localMax) {
                	localMax = calc[j];
                }
            }
            calc[i] += localMax;
            if(calc[i] > max1) {
            	max1 = calc[i];
            }
        }

        int max2 = 0;
        calc = new int[length];
        for(int i = 1; i < length; i++) {
            calc[i] = d[i];
            int localMax = 0;
        	for(int j = 1; j <= i - 2; j++) {
            	if(calc[j] > localMax) {
                	localMax = calc[j];
                }
            }
            calc[i] += localMax;
            if(calc[i] > max2) {
            	max2 = calc[i];
            }
        }


    	return Math.max(max1, max2);
    }
}
