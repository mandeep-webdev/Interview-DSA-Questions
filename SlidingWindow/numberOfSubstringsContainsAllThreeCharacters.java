//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
class Solution {
    public int numberOfSubstrings(String s) {
     
      int n = s.length();
      int result = 0;
      int l = 0;
      int[] count = new int[3];

      for(int r=0;r<n;r++){
        char ch = s.charAt(r);
        count[ch - 'a'] ++;
        while(count[0] > 0 && count[1] > 0 && count[2] > 0){
            // its a valid substring
            result+=n-r;
             count[s.charAt(l) - 'a'] -- ;
             l++;
        }
       

      }
      return result;

      
    }
}
// Brute Force TC-- O(n2) SC--O(3)
class Solution {
    public int numberOfSubstrings(String s) {
      // brute force
      int n = s.length();
      int result = 0;

      // find all substrings

      for(int i =0; i<n; i++){
        int[] count = new int[3];
        for(int j=i; j<n; j++){
            char c = s.charAt(j);
            count[c-'a']++;
            if(count[0] > 0 && count[1] > 0 && count[2] > 0){
                // find a valid substring
                result ++;

            }

        }
      }
      return result;
    }
}
