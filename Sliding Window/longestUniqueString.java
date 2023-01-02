import java.util.HashMap;

// Question from GeeksForGeeks and Leetcode Premium

class Solution{
    static int longestSubstrDistinctChars(String S){
        // overlapping computation
        // contiguous
        int i = 0, j = 0, res = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j < S.length()){
            
            // putting the j-th element
            map.put(S.charAt(j), map.getOrDefault(S.charAt(j), 0) + 1);
            
            // eliminating i-th till map[j] is unique
            // making the window valid
            while(i < j && map.get(S.charAt(j)) > 1){
                map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
                if(map.get(S.charAt(i)) == 0){
                    count -= 1;
                }
                i += 1;
            }
            
            res = Math.max(res, j - i + 1);
            j += 1;
        }
        
        return res;
    }
}