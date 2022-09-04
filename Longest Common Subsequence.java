//Recursion.


public class Solution {

	public static int lcs(String s, String t) {
		int n = s.length();
        int m = t.length();
        if(m == 0 || n == 0) return 0;
        
        return max(n - 1, m - 1, s, t);
    }
    public static int max(int ptr1, int ptr2, String s, String t) {
        //Base case
        if(ptr1 < 0 || ptr2 < 0) return 0;
        
        if(s.charAt(ptr1) == t.charAt(ptr2)) 
            return 1 + max(ptr1 - 1, ptr2 - 1, s, t);
        else return Math.max(max(ptr1 - 1, ptr2, s, t), max(ptr1, ptr2 - 1, s, t));
    }
}



//Memoization.


import java.util.*;

public class Solution {

	public static int lcs(String s1, String s2) {
		int n = s1.length();
        int m = s2.length();
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[n][m];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return max(n - 1, m - 1, s1, s2, dp);
    }
}


//Tabulation.

import java.util.*;

public class Solution {

	public static int lcs(String s1, String s2) {
		int n = s1.length();
        int m = s2.length();
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) 
                   dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}

//Space Optimized.


import java.util.*;

public class Solution {

	public static int lcs(String s1, String s2) {
		int n = s1.length();
        int m = s2.length();
        if(m == 0 || n == 0) return 0;
        int[] prev = new int[m+1];
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) 
                   curr[j] = 1 + prev[j - 1];
                else 
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];
    }
}
