//Tabulation, LCS Method.

public class Solution {
    public static int minInsertion(String s1) {
        String s2 = (new StringBuilder(s1).reverse().toString());
    	int lcs = getLCS(s1, s2);
        return s1.length() - lcs;
    }
    
    public static int getLCS(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) 
                    curr[j] = 1 + prev[j - 1];
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];
    }
}
