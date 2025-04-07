// TC-- O(n) and SC -- O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet<>();
      int l=0;
      int r=0;
      int n = s.length();
      int maxLen = 0;
      while(r<n){
        char c = s.charAt(r);
        while(set.contains(c)){ // if duplicate character exist make the window valid again
        set.remove(s.charAt(l));
        l++;
        }
        set.add(c);
        maxLen = Math.max(maxLen,r - l + 1);
        r++;
      }
      return maxLen;

    }
}

// brute Force TC-- O(n2) and SC -- O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
      // brute force
      //1. generate all substrings
      int n = s.length();
      int maxL = 0;
      

      for(int i=0; i<n;i++){
       Set<Character> set = new HashSet<>();
        for(int j=i; j<n;j++){
            char c = s.charAt(j);
            if(set.contains(c)){
                break;

            }
            set.add(c);
            maxL = Math.max(maxL,j-i+1);


        }
      }
      return maxL;

    }
}
