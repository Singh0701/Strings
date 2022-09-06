public class Solution {
    public static String shortestSupersequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1]; 
      
        //Get the LCS DP Array.
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        //Take a StringBuilder to append the characters of the Shortest Common Supersequence.
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        //Traverse the DP Array from backwards.
        while(i > 0 && j > 0) {
            if(a.charAt(i - 1) == b.charAt(j - 1)) {
                sb.append(a.charAt(i - 1));
                i--; j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(a.charAt(i - 1));
                i--;
            } else {
                sb.append(b.charAt(j - 1));
                j--;
            }
        }
        //If any part of string a is remaining then add it.
        while(i > 0) {
            sb.append(a.charAt(i - 1));
            i--;
        }
        //If any part of string b is remaining then add it.
        while(j > 0) {
            sb.append(b.charAt(j - 1));
            j--;
        }
        //As we traversed DP Array from backwards so we need to reverse and then return the string.
        return sb.reverse().toString();
    }
}


//Time complexity = O(N*M + N + M)
//Space complexity = O(N)

