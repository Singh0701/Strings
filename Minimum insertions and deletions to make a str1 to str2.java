public class Solution {
    public static int canYouMake(String str, String ptr) {
        int lcs = getLCS(str, ptr);
        int n = str.length();
        int m = ptr.length();
        return n + m - (2 * lcs);
    }
    
    public static int getLCS(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] prev = new int[m + 1];
        for(int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr;
        }
        return prev[m];
    }

}
