// Time Complexity: O(n)
//Space Complexity: O(1) -- In this problem, the input string only contains uppercase English letters (A–Z).
//So, the map can have at most 26 entries, which is constant space. So, SC = O(1) (constant), not dependent on input size.
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        // track freq of characters
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int maxL = 0;
        int maxFreq = 0;
        for(int r = 0; r<n ; r++){
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq,map.get(c));

            // check for validity
            // window size - maxFreq > k

            while( (r - l + 1) - maxFreq > k) {
                // shrink the window
                char ch = s.charAt(l);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
                l++;

            }
            maxL = Math.max(maxL, r - l + 1);

        }
    return maxL;
}
}
