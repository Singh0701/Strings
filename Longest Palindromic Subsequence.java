//Recurion.

class Solution
{
    public int longestPalinSubseq(String S)
    {
        return max(S.length() - 1, S, "");
    }
    
    public int max(int index, String s, String sub) {
        if(index < 0) {
            if(isPalindrome(sub)) return sub.length();
            else return 0;
        }
        int pick = max(index - 1, s, sub + s.charAt(index));
        int notPick = max(index - 1, s, sub);
        return Math.max(pick, notPick);
    }
    
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) 
                return false;
        }
        return true;
    }
}


//Memoiization.

class Solution
{
    public int longestPalinSubseq(String S1)
    {
        int n = S1.length();
        int m = S1.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(row, -1);
        String S2 = (new StringBuilder(S1).reverse().toString());
        return lcs(n - 1, m - 1, S1, S2, dp);
    }
    
    public int lcs(int i1, int i2, String s1, String s2, int[][] dp) {
        if(i1 < 0 || i2 < 0) {
            return 0;
        }
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2]= 1 + lcs(i1 - 1, i2 - 1, s1, s2, dp);
        } 
        else {
            return dp[i1][i2] = Math.max(lcs(i1 - 1, i2, s1, s2, dp), lcs(i1, i2 - 1, s1, s2, dp));
        }
    }
    
}


//Tabulation.


class Solution
{
    public int longestPalinSubseq(String S1)
    {
        int n = S1.length();
        int m = S1.length();
        int[][] dp = new int[n + 1][m + 1];
        String S2 = (new StringBuilder(S1).reverse().toString());
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j]= 1 + dp[i - 1][j - 1];
                } 
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
    
}

//Space optimized.

class Solution
{
    public int longestPalinSubseq(String S1)
    {
        int n = S1.length();
        int m = S1.length();
        int[] prev = new int[m + 1];
        String S2 = (new StringBuilder(S1).reverse().toString());
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    curr[j]= 1 + prev[j - 1];
                } 
                else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
    
}
