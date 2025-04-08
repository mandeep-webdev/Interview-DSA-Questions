
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
