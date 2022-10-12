class Solution {
    
    /*
        Time: o(n)
        Space: o(n)
    
    
    */
    public int lengthOfLongestSubstring(String s) {
        
        //substring = order matters
        //since there could be no duplicates, 
        //we can increment start++ as soon as we find a duplicate
        
        HashSet<Character> set = new HashSet();
        int start =0;
        int fast = 0;
        int maxSub = 0;
        
        while (start < s.length() && fast <s.length()){
            if (!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast));
                fast++;
                maxSub = Math.max(maxSub, fast - start);
            }else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        
        return maxSub;
    }
}