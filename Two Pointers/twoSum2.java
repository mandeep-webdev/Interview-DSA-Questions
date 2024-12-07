//------------------------Two Sum II - Input Array Is Sorted-----------------

//----------------------Two Poiners Approach----------------------------
// TC-- O(n)
// SC-- O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        // Given array is a sorted array hence use 2 pointers approach

        // Take 2 pointers: start and end

        int s = 0;
        int e = numbers.length-1;

        while(s<e){
            if(numbers[s] + numbers[e] > target){
                e--;

            }
            else if(numbers[s] + numbers[e] < target){
                s++;

            }
            else {
                ans[0] = s+1;
                ans[1] = e+1;
                break; // Exit the loop once we find the pair
            }

        }
        return ans;
    }
}




// --------------------Brute Force Approach -----------------------------
// TC -- O(n²)
// SC--- O(1)


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] ans = new int[2];
        for(int i = 0; i<n ; i++){
            for(int j = i+1 ; j<n; j++){
                if(numbers[i] + numbers[j] == target){
                    ans[0] = i+1; // 1-based index
                    ans[1] = j+1;
                }

            }

        }
        return ans;
    }
}

