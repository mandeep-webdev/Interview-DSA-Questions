//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
// TC -- O(n) SC--O(3)
class Solution {
    public int numberOfSubstrings(String s) {
     int n = s.length();
     int l = 0;
     // count substrings
     int count = 0;
     // tract freq of characters
     int[] arr = new int[3];

     for(int r=0; r<n; r++){
        char ch = s.charAt(r);
        arr[ch-'a'] ++ ;
         // shrink from left while window contains a, b, c
        while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0 ){
             count = count + n - r;
            // shrink the window to count min valid substring
            arr[s.charAt(l) - 'a'] -- ;
            l++;
        }

     }
     return count;
     
    }
}
// Brute Force TC-- O(n2) SC--O(3)
class Solution {
    public int numberOfSubstrings(String s) {
     // brute force
     int n = s.length();
     // counting the total no. of substring
     int count = 0;

     // generate all substrings

     for(int i = 0 ; i<n ;i++) {
        // track freq of characters
        int[] arr = new int[3];
        for(int j=i; j<n; j++){
            char ch = s.charAt(j);
            arr[ch - 'a'] = 1;
            if(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
                // a valid substring
                count = count + (n - j);
                break;
            }

        }

     }
     return count;

     
    }
}
