import java.util.*;
import java.lang.*;
import java.io.*;
class CountSubarray {
    
    static int countSubarray(int n, long k, int [] arr) {
        int count = 0;
        long product = 1;
        int first = 0;
        int second = 0;
        
        while(first < n) {
            product = arr[first] * product;
            if(arr[first] >= k) {
                first++;
                second = first;
                product = 1;
            } else if(product >= k) {
                while(product >= k && second < n) {
                    product = product / arr[second];
                    second++;
                }
                count = count + (first - second + 1);
                first++;
            } else {
                count = count + (first - second + 1);
                first++;
            }
        }
        
        return count;
    }
    
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        
        for(int j = 0; j < t; j++) {
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+"); 
            
            int n = Integer.parseInt(strs[0]);
            long k = Long.parseLong(strs[1]);
            int arr[] = new int[n];
            line = br.readLine(); 
            strs = line.trim().split("\\s+"); 
  
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(strs[i]); 
            }
            
            System.out.println(countSubarray(n, k, arr));
        }
        br.close();
	}
}