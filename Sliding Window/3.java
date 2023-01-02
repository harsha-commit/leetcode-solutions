import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int res = 0;

        while(j < s.length()){
            // character can be symbols and digits
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while(i < j && map.get(s.charAt(j)) > 1){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i += 1;
            }

            res = Math.max(res, j - i + 1);
            j += 1;
        }

        return res;
    }
}