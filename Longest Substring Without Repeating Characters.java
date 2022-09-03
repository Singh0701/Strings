//Approach 1: Naive Approach using a Set to check for duplicates.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int maxLength = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < n; j++) {
                if(set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}

//Time 

//Approach 2: Using two poiinters and a HashMap.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int n = s.length();
        int left = 0, right = 0;
        while(right < n) {
            if(set.contains(s.charAt(right))) {
                while(left < n && set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left++));
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
            set.add(s.charAt(right++));
        }
        return maxLength;
    }
}
