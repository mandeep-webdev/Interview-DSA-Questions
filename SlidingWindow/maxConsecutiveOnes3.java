// ----- sliding window---- TC--O(n) and SC-- O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
     int l = 0;
     int n = nums.length;
     int zeros = 0;
     int maxL = 0;

     for(int r = 0; r<n; r++){
        // if element is zero
        if(nums[r] == 0) {
            zeros ++;
        }
        // if window becomes invalid, shrink it
        if(zeros > k) {
            while(zeros > k){
                if(nums[l] == 0){
                    zeros --;
                   
                }
                 l++;

            }

        }
        // if it is a valid window

        maxL = Math.max(maxL, r-l + 1);

     }
     return maxL;
    }
}
// Brute Force -------- TC -- O(n2) and SC -- O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
       // brute force -- change the problem into find the longest subarray with atmost k zeros
       // 1. generate all subarrays

       int n = nums.length;
       int maxL = 0;

       for(int i=0; i<n; i++) {
        int zeros = 0; // track how many zeros have seen is this particular subarray
        for(int j=i; j<n; j++) {

            if(nums[j] == 0) { // if zeros seen
            zeros++;
            }
            
            if(zeros > k) {
                break;
            }

            maxL = Math.max(maxL,j-i +1);

        }
       }
       return maxL;
    }
}
