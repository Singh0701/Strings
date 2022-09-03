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

//Time complexity = O(N^2)
//Space complexity = O(N)

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

//Time complexity = O(N + N)
//Space complexity = O(N)


//Approach 3: Using Map to store the last index of char.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLength = 0;
        int n = s.length();
        int left = 0;
        for(int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if(lastIndex.containsKey(c) && lastIndex.get(c) >= left) {
                left = lastIndex.get(c) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            lastIndex.put(c, right);
        }
        return maxLength;
    }
}


//Time complexity = O(N)
//Space complexity = O(N)


