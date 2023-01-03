import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        k = k + 1;
        int i = 0, j = 0;
        while(j < nums.length){

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            if(j - i + 1 <= k && map.containsKey(nums[j]) && map.get(nums[j]) > 1){
                return true;
            }

            if(j - i + 1 == k){
                map.put(nums[i], map.get(nums[i]) - 1);
                i += 1;
            }
            
            j += 1;
        }
        return false;
    }
}