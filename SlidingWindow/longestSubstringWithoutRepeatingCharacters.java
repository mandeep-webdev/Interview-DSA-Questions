// solved using hashmap

class Solution {
    public int lengthOfLongestSubstring(String s) {
      Map<Character,Integer> map = new HashMap<>();
      int l=0;
      int n = s.length();
      int maxLen = 0;
      for(int r = 0; r<n; r++){
        char c = s.charAt(r);
        // if charac already seen and is part of current window
        if(map.containsKey(c) && map.get(c)>=l){
            l = map.get(c) + 1;

        }
        map.put(c,r);
        maxLen = Math.max(maxLen,r - l + 1);
        
      }
      return maxLen;

    }
}
// solved using set
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
