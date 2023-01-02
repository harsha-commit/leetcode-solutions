import java.util.HashMap;

/*
 * Given two strings s and t of lengths m and n respectively, return the minimum window 
   substring of s such that every character in t (including duplicates) is included in the window. 
   If there is no such substring, return the empty string "".
 */

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0, j = 0, res = Integer.MAX_VALUE;
        int x = -1, y = -1;
        int count = 0;

        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0){
                    count += 1; 
                }
            }

            while(count == map.size()){
                if(j - i + 1 < res){
                    res = j - i + 1;
                    x = i; 
                    y = j;
                } 
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if(map.get(s.charAt(i)) > 0){
                        count -= 1;
                    }
                }
                i += 1;
            }

            j += 1;
        }

        // no result case
        if(x == -1)
            return "";

        return s.substring(x, y + 1);
    }
}