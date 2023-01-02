class Solution {
    public int totalFruit(int[] fruits) {
        // 0 <= fruits[i] < fruits.length

        int[] map = new int[fruits.length];

        for(int i = 0; i < fruits.length; i++){
            map[i] = 0;
        }

        int i = 0,  j = 0, res = 0;
        int count = 0;

        while(j < fruits.length){
            map[fruits[j]] += 1;
            if(map[fruits[j]] == 1)
                count += 1;

            while(i < j && count > 2){
                map[fruits[i]] -= 1;
                if(map[fruits[i]] == 0)
                    count -= 1;
                i += 1;
            }

            res = Math.max(j-i+1, res);
            j += 1;
        }
        return res;
    }
}