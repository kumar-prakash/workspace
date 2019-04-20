import java.util.*;
import java.io.*;

public class LCS {
    public static int findLCSLength(String s1, String s2) {
        return 0;
    }

    static int commonChild(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int maxCount = 0;
        
        int [] calc = new int[l2];
        for(int i = 0; i < l1; i++) {
            int max = 0;
            char target = s1.charAt(i);
            for(int j = 0; j < l2; j++) {
                if(s2.charAt(j) == target) {
                    if(calc[j] > max) {
                        max = calc[j];
                    }
                    calc[j] = max + 1;
                    if(calc[j] > maxCount) {
                        maxCount = calc[j];
                    }
                } else if(calc[j] > max) {
                    max = calc[j];
                }
            }
        }
        
        return maxCount;
    }
    
	public static void main (String[] args) throws IOException {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 
        
        String line;
        String[] strs;
        for(int j = 0; j < t; j++) {
            line = br.readLine();
            strs = line.trim().split("\\s+");
            
            int length1 = Integer.parseInt(strs[0]);
            int length2 = Integer.parseInt(strs[1]);
            String str1 = br.readLine().trim();
            String str2 = br.readLine().trim();
            
            if(length1 < length2) {
                System.out.println(findLCS(str1, str2));    
            } else {
                System.out.println(findLCS(str2, str1));
            }
            
        }
        br.close();
        */
        //findLCS("ABCDGH", "AEDFHR");
        findLCS("AC", "ABC");
	}
}