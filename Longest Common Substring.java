//Brute Force: Generate all the subStrings for s1 and s2 and compare if any matches then pick the one with the maximum length.



//Tabulation. 

import java.util.*;
public class Solution {
	public static int lcs(String str1, String str2) {
		int n = str1.length();
        int m = str2.length();
        if(n == 0 || m == 0) return 0;
        int maxLength = 0;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
	}
}

//Space Optimization.

import java.util.*;
public class Solution {
	public static int lcs(String str1, String str2) {
		int n = str1.length();
        int m = str2.length();
        if(n == 0 || m == 0) return 0;
        int maxLength = 0;
        int[] prev = new int[m + 1];
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                }
                maxLength = Math.max(maxLength, curr[j]);
            }
            prev = curr;
        }
        return maxLength;
	}
}
