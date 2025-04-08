class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxL = 0;
        int l = 0;
         Map<Integer,Integer> map = new HashMap<>();

         for(int r = 0; r<n ; r++){
            map.put(fruits[r],map.getOrDefault(fruits[r],0) + 1);
            if(map.size()>2){
                //need to shrink the window
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if(map.get(fruits[l] ) == 0){
                    map.remove(fruits[l]);
                    
                }
                l++;
                
            }
            maxL = Math.max(maxL, r-l + 1);

         }

return maxL;
        
    }
}

// brute force
class Solution {
    public int totalFruit(int[] fruits) {
        // brute force
        int n = fruits.length;
        int maxL = 0;

        for(int i = 0; i<n ; i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i; j<n; j++){
                map.put(fruits[j],map.getOrDefault(fruits[j],0) + 1);
                // atmost 2 types can be choosed
                if(map.size() > 2) {
                    break;

                }
                maxL = Math.max(maxL, j-i +1);

            }
        }
        return maxL;
    }
}
